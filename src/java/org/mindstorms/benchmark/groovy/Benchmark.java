package org.mindstorms.benchmark.groovy;

import groovy.lang.Closure;
import org.mindstorms.benchmark.JobExecutor;

import java.util.List;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 1, 2008
 */
abstract public class Benchmark extends org.mindstorms.benchmark.Benchmark {
  public static void benchmark(Closure closure) {
    executeBenchmark(0, closure);
  }

  public static void rbenchmark(Closure closure) {
    executeBenchmark(1, closure);
  }

  public static void rbenchmark(int rehersals, Closure closure) {
    executeBenchmark(rehersals, closure);
  }

  //
  // aliases
  //
  public static void bm(Closure closure) {
    executeBenchmark(0, closure);
  }

  public static void rbm(Closure closure) {
    executeBenchmark(1, closure);
  }

  public static void rbm(int rehersals, Closure closure) {
    executeBenchmark(rehersals, closure);
  }

  private static void executeBenchmark(int rehersals, Closure closure) {
    if(closure.getMaximumNumberOfParameters() != 1) {
      throw new RuntimeException("The closure should accept exactly 1 parameter, but it currently takes "
          + closure.getMaximumNumberOfParameters());
    }
    JobExecutor jobExecutor= new JobExecutor();
    closure.call(jobExecutor);
    execute(rehersals, jobExecutor);
  }

  private Benchmark() {}
}
