package org.mindstorms.benchmark.time.sys;

import com.sun.jna.Structure;
import com.sun.jna.NativeLong;
import org.mindstorms.benchmark.time.Tms;

/**
 * <p/>
 * See {@link ISysTimesLib} for an explanation
 * of the mapping <code>clock_t -> NativeLong</code>.
 * <p/>
 * The different values are measured in number of clock ticks per second.
 * This value should be retrieved using the syscall in unistd.h
 * <code>long sysconf(int name)</code> with <code>_SC_CLK_TCK</code>.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 * @see ISysTimesLib
 */
public class TmsStruct extends Structure implements Tms {
   /** user CPU time */
  public NativeLong tms_utime;
  /** system CPU time */
  public NativeLong tms_stime;
  /** user CPU time of terminated child processes */
  public NativeLong tms_cutime;
  /** system CPU time of terminated child processes */
  public NativeLong tms_cstime;

  private final long m_clockTicksPerSecond;

  public TmsStruct(long ticks) {
    m_clockTicksPerSecond = ticks;
  }
  
  public double getUtime() {
    return getValue(tms_utime)/m_clockTicksPerSecond;
  }

  public double getStime() {
    return getValue(tms_stime)/m_clockTicksPerSecond;
  }

  public double getCutime() {
    return getValue(tms_cutime)/m_clockTicksPerSecond;
  }

  public double getCstime() {
    return getValue(tms_cstime)/m_clockTicksPerSecond;
  }

  private double getValue(NativeLong nlong) {
    return nlong != null ? nlong.longValue() : 0D;  
  }

  public String toString() {
    return "U:" + getUtime() + " S:" + getStime() + " CU:" + getCutime() + " CS:" + getCstime();
  }
}
