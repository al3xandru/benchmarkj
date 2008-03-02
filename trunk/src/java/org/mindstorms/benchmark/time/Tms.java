package org.mindstorms.benchmark.time;

/**
 * Contract of the time structure. The time resolution is second.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public interface Tms {
  double getUtime();
  double getStime();
  double getCutime();
  double getCstime();
}
