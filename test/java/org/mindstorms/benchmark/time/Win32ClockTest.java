package org.mindstorms.benchmark.time;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.mindstorms.benchmark.DummyJob;
import org.mindstorms.benchmark.time.win32.IWin32ClockLib;
import com.sun.jna.NativeLong;

/**
 * This class/interface does XXX
 */
public class Win32ClockTest {
    @Test
    public void invokeClockFunction() {
        IWin32ClockLib clockLib= ProcessTimesProvider.loadWindowsLibC();
        assertNotNull("clock library not available", clockLib);
        NativeLong start= clockLib.clock();
        long jStart= System.currentTimeMillis();
        doSomething();
        NativeLong stop= clockLib.clock();
        long jStop= System.currentTimeMillis();
        System.out.println("Start:" + start.longValue());
        System.out.println("Stop :" + stop.longValue());
        System.out.println("Nativ:" + (stop.longValue() - start.longValue()));
        System.out.println("Java :" + (jStop - jStart) + " ms");
    }

    private void doSomething() {
        new DummyJob().run();
    }
}
