package org.mindstorms.benchmark.time;

import org.mindstorms.benchmark.time.win32.IWin32ClockLib;
import org.mindstorms.benchmark.time.win32.IWin32TimeLib;
import org.mindstorms.benchmark.time.win32.Win32ProcessTimesFunction;
import org.mindstorms.benchmark.time.sys.SysProcessTimesFunction;
import org.mindstorms.benchmark.time.sys.ISysTimesLib;
import com.sun.jna.Native;

import java.util.HashMap;

/**
 * A factory for the OS specific ProcessTimesFunction. In case the OS is unknown
 * the {@link DefaultProcessTimesFunction} is returned.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class ProcessTimesProvider {
  private static final int MAC_SC_CLK_TCK= 3;
  private static final int LINUX_SC_CLK_TCK= 2;

  private static final ProcessTimesProvider INSTANCE= new ProcessTimesProvider();
  private static final ProcessTimesFunction DEFAULT_PROCESSTIMES= new DefaultProcessTimesFunction();
  private ProcessTimesFunction m_processTimesFunction;
  
  private ProcessTimesProvider() {
    m_processTimesFunction = createOSProcessTimes();
  }
  
  public static ProcessTimesFunction getProcessTimes() {
    return INSTANCE.m_processTimesFunction;
  }

  private ProcessTimesFunction createOSProcessTimes() {
    String os = System.getProperty("os.name");
    if(os.startsWith("Mac OS") || os.startsWith("Darwin")) {
      return new SysProcessTimesFunction(loadMacOSLibC(), MAC_SC_CLK_TCK);
    }
    else if(os.startsWith("Linux")) {
      return new SysProcessTimesFunction(loadLinuxLibC(), LINUX_SC_CLK_TCK);
    }
    else if(os.startsWith("Windows")) {
      return new Win32ProcessTimesFunction(loadWindowsKernel32(), loadWindowsLibC());
    }
    else {
      return DEFAULT_PROCESSTIMES;
    }
  }

  static IWin32ClockLib loadWindowsLibC() {
    return (IWin32ClockLib) Native.loadLibrary("msvcrt", IWin32ClockLib.class, new HashMap<Object, Object>());
  }

  static IWin32TimeLib loadWindowsKernel32() {
      return (IWin32TimeLib) Native.loadLibrary("kernel32", IWin32TimeLib.class, new HashMap<Object, Object>());
  }

  static ISysTimesLib loadLinuxLibC() {
    return (ISysTimesLib) Native.loadLibrary("c", ISysTimesLib.class, new HashMap<Object, Object>());
  }

  static ISysTimesLib loadMacOSLibC() {
    return (ISysTimesLib) Native.loadLibrary("c", ISysTimesLib.class, new HashMap<Object, Object>());
  }
}
