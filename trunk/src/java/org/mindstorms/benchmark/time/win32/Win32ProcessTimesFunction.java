package org.mindstorms.benchmark.time.win32;

import org.mindstorms.benchmark.time.ProcessTimesFunction;
import org.mindstorms.benchmark.time.Tms;
import com.sun.jna.NativeLong;

/**
 * Implementation of the ProcessTimesFunction for Windows.
 * It firstly attempts to retrieve the information using Win32 API then
 * falling back to the <code>clock<code> sys call.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class Win32ProcessTimesFunction implements ProcessTimesFunction {
  private static final long CLOCKS_PER_SEC= 1000L;
  
  private final IWin32TimeLib m_timeLib;
  private final IWin32ClockLib m_clockLib;
  
  public Win32ProcessTimesFunction(IWin32TimeLib timeLib, IWin32ClockLib clockLib) {
    m_timeLib= timeLib;
    m_clockLib= clockLib;
  }
  
  public Tms getTms() {
    TmsStruct tms;

    FileTime kernelFT= new FileTime();
    FileTime userFT= new FileTime();
    if(m_timeLib.GetProcessTimes(m_timeLib.GetCurrentProcess(), new FileTime(), new FileTime(), kernelFT, userFT)) {
      tms= new TmsStruct(userFT.toClock(), kernelFT.toClock());
    }
    else {
      NativeLong nlong= m_clockLib.clock();
      tms= new TmsStruct(nlong.doubleValue() / CLOCKS_PER_SEC);
    }

    return tms;
  }
}
