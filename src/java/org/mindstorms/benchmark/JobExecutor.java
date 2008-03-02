package org.mindstorms.benchmark;

import org.mindstorms.benchmark.time.Times;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that allows registering multiple jobs/code blocks
 * for later benchmarking.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class JobExecutor {
  private List<Job> m_jobs= new ArrayList<Job>();

  /**
   * Sole constructor (<em>for internal usage only</em>).
   */
  public JobExecutor() {}
  
  /**
   * Schedule a job/code block for benchmarking.
   *
   * @param job the job/code block to be benchmarked
   */
  public void benchmark(Runnable job) {
    addJob("", job);
  }

  /**
   * Schedule a <code>label</code>ed job/code block for benchmarking.
   *
   * @param label the label for the current job/code block.
   * @param job the job/code block to be benchmarked
   */
  public void benchmark(String label, Runnable job) {
    addJob(label, job);
  }

  /**
   * Alias for {@link #benchmark(Runnable)}.
   */
  public void bm(Runnable job) {
    addJob("", job);
  }

  /**
   * Alias for {@link #benchmark(String, Runnable)}.
   */
  public void bm(String label, Runnable job) {
    addJob(label, job);
  }
  
  List<Job> getJobs() {
    return m_jobs;
  }

  private void addJob(String label, Runnable job) {
    m_jobs.add(new Job(job, label));
  }
  
  static class Job {
    private final Runnable m_job;
    private final String m_label;
    
    public Job(Runnable job, String lbl) {
      m_job= job;
      m_label= lbl;
    }

    public Times run() {
      return Benchmark.measure(m_label, m_job);
    }
  }
}
