package org.mindstorms.benchmark.time.sys;

import org.mindstorms.benchmark.time.ProcessTimesFunction;
import org.mindstorms.benchmark.time.Tms;

/**
 * Implementation of ProcessTimesFunction for OSes that provide an
 * implementation for <code>sys/times.h</code>.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class SysProcessTimesFunction implements ProcessTimesFunction {
  private final ISysTimesLib m_lib;
  private final long m_clockTicksPerSecond;
  
  public SysProcessTimesFunction(ISysTimesLib timesLib, int _sc_clk_tck) {
    m_lib= timesLib;
    m_clockTicksPerSecond= timesLib.sysconf(_sc_clk_tck);
  }
  
  public Tms getTms() {
    TmsStruct tms= new TmsStruct(m_clockTicksPerSecond);
    m_lib.times(tms);
    
    return tms;
  }
}
