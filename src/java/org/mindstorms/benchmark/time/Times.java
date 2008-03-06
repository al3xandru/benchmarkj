package org.mindstorms.benchmark.time;


import static org.mindstorms.benchmark.util.ReportingUtil.header;
import static org.mindstorms.benchmark.util.ReportingUtil.reportFormat;

import java.util.Formatter;

/**
 * This object contains timing information about a specific job/code block execution.
 * The only methods
 * that should be accessed by the client code are {@link #toString()} which
 * will return the formatted string representation and
 * {@link #toFullString()} that will also include the record header.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class Times {
  private static final long NANOS= 1000000000L;
  public static final String CAPTION= "     user         system       total         real";
  public static final String FMT= "%$12.6f %$12.6f %$12.6f (%$12.6f)";
  private static final String NL= System.getProperty("line.separator");

  private double m_userTime;
  private double m_sysTime;
  private double m_totalTime;
  private double m_realTime;
  private String m_label;

  /**
   * <em>Note: for internal usage only</em>
   */  
  public Times(Tms startTms, Tms stopTms, long start, long stop, String label) {
    m_userTime= stopTms.getUtime() - startTms.getUtime();
    m_sysTime= stopTms.getStime() - startTms.getStime();
    m_totalTime= computeTotal(startTms, stopTms);
    m_realTime= computeReal(start, stop);
    m_label= label != null ? label : "";
  }

  /**
   * <em>Note: for internal usage only</em>
   */  
  public Times(double user, double sys, double total, double real, String lbl) {
    m_userTime= user;
    m_sysTime= sys;
    m_totalTime= total;
    m_realTime= real;
    m_label= lbl;
  }

  /**
   * <em>Note: for internal usage only</em>
   */  
  public String getLabel() {
    return m_label;
  }

  /**
   * <em>Note: for internal usage only</em>
   */
  public String format(String format) {
    return new Formatter().format(format, m_label, m_userTime, m_sysTime, m_totalTime, m_realTime)
        .toString();
  }

  /**
   * Returns a formatted string representation of the recorded times.
   * <p/>
   * For an output including the header use {@link #toFullString()}.
   *
   * @return string representation
   */
  public String toString() {
    return format(reportFormat(FMT, this));
  }

  /**
   * Returns a header and a formatted string representation of the recorded times
   *
   * @return complete string representation
   */
  public String toFullString() {
    return header(CAPTION, this) + NL + toString();   
  }
  
  /**
   * <em>Note: for internal usage only</em>
   *
   * @return job execution real time
   */
  public double getRealTime() {
    return m_realTime;
  }

  /**
   * <em>Note: for internal usage only</em>
   *
   * @return job user time
   */
  public double getUserTime() {
    return m_userTime;
  }

  /**
   * <em>Note: for internal usage only</em>
   *
   * @return job system time
   */
  public double getSysTime() {
    return m_sysTime;
  }

  /**
   * <em>Note: for internal usage only</em>
   *
   * @return job total execution time (user + system)
   */
  public double getTotalTime() {
    return m_totalTime;
  }
  
  private double computeReal(long start, long stop) {
    double diff= stop - start;
    return diff / NANOS;
  }

  private double computeTotal(Tms start, Tms stop) {
    double totalTime= stop.getUtime() - start.getUtime();
    totalTime += stop.getStime() - start.getStime();
    totalTime += stop.getCutime() - start.getCutime();
    totalTime += stop.getCstime() - start.getCstime();

    return totalTime;
  }
}
