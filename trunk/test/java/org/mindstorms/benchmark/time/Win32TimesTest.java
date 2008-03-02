package org.mindstorms.benchmark.time;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import static org.mindstorms.benchmark.Assertions.assertGreater;
import static org.mindstorms.benchmark.Assertions.assertGreaterOrEqual;

import org.junit.Test;

import org.mindstorms.benchmark.DummyJob;

import org.mindstorms.benchmark.time.win32.IWin32TimeLib;
import org.mindstorms.benchmark.time.win32.FileTime;
import com.sun.jna.Pointer;

/**
 * This class/interface does XXX
 */
public class Win32TimesTest {
  @Test
  public void invokeGetProcessTimes() {
    IWin32TimeLib timesLib = ProcessTimesProvider.loadWindowsKernel32();

    assertNotNull("times library not available", timesLib);

    Pointer p = timesLib.GetCurrentProcess();
    assertNotNull("pointer to current process cannot be null", p);

    process();

    FileTime kernelFT = new FileTime();
    FileTime userFT = new FileTime();
    boolean result= timesLib.GetProcessTimes(p, new FileTime(), new FileTime(), kernelFT, userFT);

    assertTrue("GetProcessTimes failed", result);
    assertGreater(userFT.toClock(), 0);
    assertGreaterOrEqual(kernelFT.toClock(), 0);
  }

  private void process() {
    new DummyJob().run();
  }
}
