package org.mindstorms.benchmark.time;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.mindstorms.benchmark.time.sys.ISysTimesLib;
import org.mindstorms.benchmark.Assertions;
import static org.mindstorms.benchmark.Assertions.assertGreater;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class MacSysconfTest {
  @Test
  public void sysconf() {
    ISysTimesLib times= ProcessTimesProvider.loadMacOSLibC();
    assertNotNull("Mac libc library was not loaded", times);
    long result= times.sysconf(3);
    assertGreater(result, 0);
  }
}
