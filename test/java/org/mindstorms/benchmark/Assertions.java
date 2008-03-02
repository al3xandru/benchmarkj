package org.mindstorms.benchmark;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 2, 2008
 */
public class Assertions {
  public static void assertGreater(long actual, long expected) {
    if(actual > expected) return;

    throw new AssertionError("Expected bigger than <" + expected + ">, actual <" + actual + "> ");
  }

  public static void assertGreater(double actual, double expected) {
    if(actual > expected) return;

    throw new AssertionError("Expected bigger than <" + expected + ">, actual <" + actual + "> ");
  }

  public static void assertGreaterOrEqual(double actual, double expected) {
    if(actual >= expected) return;

    throw new AssertionError("Expected bigger or equals than <" + expected + ">, actual <" + actual + "> ");
  }
}
