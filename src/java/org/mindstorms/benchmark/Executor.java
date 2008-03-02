package org.mindstorms.benchmark;

/**
 * A callback interface that should be implemented by the client code
 * in order to register multiple jobs/code blocks in the
 * {@link org.mindstorms.benchmark.JobExecutor}.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 1, 2008
 */
public interface Executor {
  /**
   * Callback method that provides access to the
   * {@link org.mindstorms.benchmark.JobExecutor} that allows
   * registering multiple jobs/code blocks to be benchmarked.
   * 
   * @param executor an object allowing the registration of
   * multiple jobs/code blocks for benchmarking
   */
  void execute(JobExecutor executor);
}
