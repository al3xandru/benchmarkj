package org.mindstorms.benchmark.time;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.mindstorms.benchmark.time.sys.ISysTimesLib;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class LinuxSysconfTest {
  @Test
  public void sysconf() {
    ISysTimesLib times= ProcessTimesProvider.loadLinuxLibC();
    assertNotNull("Linux libc library was not loaded", times);
    long result= times.sysconf(3);
    assertTrue("sysconf() expected > 0L, actual " + result, result > 0L);
  }
}