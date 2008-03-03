package org.mindstorms.benchmark;

import org.junit.Test;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 1, 2008
 */
public class RehearsedBenchmarkTest {
  @Test
  public void rbenchmark() {
    Benchmark.rbench(5, new Executor() {
      public void execute(JobExecutor executor) {
        executor.benchmark("labbeled", new DummyJob());
        executor.benchmark(new DummyJob());
        executor.benchmark("longer than reher", new DummyJob());
      }
    });
  }
}
