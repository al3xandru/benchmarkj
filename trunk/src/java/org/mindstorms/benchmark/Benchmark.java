package org.mindstorms.benchmark;

import org.mindstorms.benchmark.time.ProcessTimesFunction;
import org.mindstorms.benchmark.time.ProcessTimesProvider;
import org.mindstorms.benchmark.time.Times;
import org.mindstorms.benchmark.time.Tms;
import org.mindstorms.benchmark.util.ReportingUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Benchmarking utility class. Provides different ways to benchmark
 * jobs/code blocks.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
abstract public class Benchmark {
  /**
   * Measure the execution time of the provided <code>job</code>.
   *
   * @param job the block to be executed
   * @return execution time
   */
  public static Times measure(Runnable job) {
    return measure("", job);
  }

  /**
   * Measure the execution time of the provided <code>job</code>.
   * The report will be labeled.
   *
   * @param label the label of the report
   * @param job the block to be executed
   * @return execution time
   */
  public static Times measure(String label, Runnable job) {
    ProcessTimesFunction function= ProcessTimesProvider.getProcessTimes();
    long start= System.nanoTime();
    Tms startTms= function.getTms();
    long stop;
    Tms stopTms;
    try {
      job.run();
    }
    finally {
      stopTms= function.getTms();
      stop= System.nanoTime();
    }
    
    return new Times(startTms, stopTms, start, stop, label);
  }

  /**
   * Benchmark one or multiple jobs/code blocks. These will be registered
   * with the {@link org.mindstorms.benchmark.JobExecutor} that is passed
   * in to the unique {@link org.mindstorms.benchmark.Executor#execute(JobExecutor)}
   * method.
   * <p/>
   * Example:
   * <pre>
   * Benchmark.benchmark(new Executor() {
   *   public void execute(JobExecutor je) {
   *     je.benchmark(job1);
   *     je.benchmark(job2);
   *   }
   * });
   * </pre>
   * @param exec a callback that allows registering multiple tasks to be
   *  benchmarked
   */
  public static void bench(Executor exec) {
    executeBenchmark(0, exec);
  }

  /**
   * Benchmark one or multiple jobs/code blocks that are registered through the
   * {@link org.mindstorms.benchmark.JobExecutor} that is passed
   * in to the unique {@link org.mindstorms.benchmark.Executor#execute(JobExecutor)}
   * method.
   * <p/>
   * The tasks will be executed firstly as a rehearsal, and only afterwards for
   * real timings. Both reports will be outputted.
   * <p/>
   * See code sample: {@link #bench(Executor)}.
   *
   * @param exec a callback that allows registering multiple tasks to be
   *  benchmarked
   * @see #rbench(int, Executor)
   */
  public static void rbench(Executor exec) {
    executeBenchmark(1, exec);
  }

  /**
   * Benchmark one or multiple jobs/code blocks that are registered through the
   * {@link org.mindstorms.benchmark.JobExecutor} that is passed
   * in to the unique {@link org.mindstorms.benchmark.Executor#execute(JobExecutor)}
   * method.
   * <p/>
   * The tasks will be executed firstly as a rehearsal for <code>rehearsals</code> times,
   * and only afterwards for real timing. A summary report for the rehearsal timings
   * will be outputted.
   * <p/>
   * See code sample: {@link #bench(Executor)}.
   *
   * @param exec a callback that allows registering multiple tasks to be
   *  benchmarked
   * @param rehearsals the number of rehearsals to be executed prior to measuring
   * @see #rbench(int, Executor)
   */
  public static void rbench(int rehearsals, Executor exec) {
    executeBenchmark(rehearsals, exec);
  }

  //
  // aliases
  //
  /**
   * Alias for {@link #bench(Executor)}.
   *
   * @see # bench (Executor)
   */
  public static void bm(Executor exec) {
    bench(exec);
  }

  /**
   * Alias for {@link #rbench(Executor)}.
   *
   * @see # rbench (Executor)
   */
  public static void rbm(Executor exec) {
    rbench(1, exec);
  }

  /**
   * Alias for {@link #rbench(int, Executor)}.
   *
   * @see # rbench (int, Executor)
   */
  public static void rbm(int rehearsals, Executor exec) {
    rbench(rehearsals, exec);
  }

  private static void executeBenchmark(int rehearsals, Executor exec) {
    JobExecutor jobExecutor= new JobExecutor();
    exec.execute(jobExecutor);

    execute(rehearsals, jobExecutor);
  }
  
  protected static void execute(int rehearsals, JobExecutor jobExecutor) {
    List<JobExecutor.Job> jobs= jobExecutor.getJobs();

    List<List<Times>> rehersalTimes= new ArrayList<List<Times>>(rehearsals);
    for(int i= 0; i < rehearsals; i++) {
      rehersalTimes.add(execute(jobs));
    }

    List<Times> results= execute(jobs);

    printAll(rehersalTimes);
    print(null, results);
  }
  
  private static List<Times> execute(List<JobExecutor.Job> jobs) {
    List<Times> times= new ArrayList<Times>(jobs.size());
    for(JobExecutor.Job j : jobs) {
      times.add(j.run());
    }

    return times;
  }

  private static void printAll(List<List<Times>> results) {
    if(results.size() > 3) {
      List<List<Times>> computedResults= computeResults(results);
      print("Rehearsal Max", computedResults.get(0));
      System.out.println("");
      print("Rehearsal Min", computedResults.get(1));
      System.out.println("");
      print("Rehearsal Avg", computedResults.get(2));
      System.out.println("");
    }
    else {
      for(List<Times> r : results) {
        print("Rehearsal", r);
        System.out.println("");
      }
    }
    if(results.size() > 0) {
      System.out.println("");
    }
  }

  private static void print(String captionPrefix, List<Times> results) {
    Times[] times= toArray(results);
    String capture= ReportingUtil.header(Times.CAPTION, captionPrefix,  times);
    String format= ReportingUtil.reportFormat(Times.FMT, captionPrefix,  times);
    System.out.println(capture);
    for(Times t : results) {
      System.out.println(t.format(format));
    }
  }

  private static List<List<Times>> computeResults(List<List<Times>> values) {
    List<List<Times>> res= new ArrayList<List<Times>>(3);
    List<Times> maxTime= null;
    List<Times> minTime= null;
    double max= 0D;
    int size= values.get(0).size();

    double min= Double.POSITIVE_INFINITY;
    double[] userT= new double[size];
    double[] sysT= new double[size];
    double[] totalT= new double[size];
    double[] realT= new double[size];
    String[] lbls= new String[size];
    
    for(List<Times> set : values) {
      double realTime= computeRealTimeTotal(set);
      if(realTime > max) {
        max= realTime;
        maxTime= set;
      }
      if(realTime < min) {
        min= realTime;
        minTime= set;
      }
      for(int i=0; i < set.size(); i++) {
        Times t= set.get(i);
        userT[i]+=t.getUserTime();
        sysT[i]+=t.getSysTime();
        totalT[i]+=t.getTotalTime();
        realT[i]+=t.getRealTime();
        lbls[i]=t.getLabel();
      }
    }

    res.add(maxTime);
    res.add(minTime);

    int count= values.size();
    List<Times> avgs= new ArrayList<Times>(size);
    for(int i= 0; i < size; i++) {
      avgs.add(new Times(userT[i]/count, sysT[i]/count, totalT[i]/count, realT[i]/count, lbls[i]));
    }
    res.add(avgs);

    return res;
  }

  private static double computeRealTimeTotal(List<Times> values) {
    double total= 0;
    for(Times t : values) {
      total += t.getRealTime();
    }

    return total;
  }
  
  private static Times[] toArray(List<Times> times) {
    return times.toArray(new Times[times.size()]);
  }
}
