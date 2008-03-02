package org.mindstorms.benchmark;

import static org.mindstorms.benchmark.util.ReportingUtil.header;

import org.junit.Test;
import org.mindstorms.benchmark.time.Times;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class MeasureTest {
  @Test
  public void noLabelMeasure() {
    Times t= Benchmark.measure(new DummyJob());
    System.out.println(header(Times.CAPTION, t));
    System.out.println(t);
  }

  @Test
  public void labeledMeasure() {
    Times t= Benchmark.measure("labeled", new DummyJob());
    System.out.println(t.toFullString());
  }
}
