package org.mindstorms.benchmark.time.win32;

import org.mindstorms.benchmark.time.Tms;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class TmsStruct implements Tms {
  private final double tms_utime;
  private final double tms_stime;
  
  public TmsStruct(double userTime) {
    this(userTime, 0D);
  }
  public TmsStruct(double uTime, double sTime) {
    tms_utime= uTime;
    tms_stime= sTime;
  }
  public double getUtime() {
    return tms_utime;
  }

  public double getStime() {
    return tms_stime;
  }

  public double getCutime() {
    return 0;
  }

  public double getCstime() {
    return 0;
  }
}
