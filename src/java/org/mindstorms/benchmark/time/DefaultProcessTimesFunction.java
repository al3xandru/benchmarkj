package org.mindstorms.benchmark.time;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class DefaultProcessTimesFunction implements ProcessTimesFunction {
  private static final long FIRST_KNOWN_TIME= System.currentTimeMillis();
  
  public Tms getTms() {
    return null;
  }
}
