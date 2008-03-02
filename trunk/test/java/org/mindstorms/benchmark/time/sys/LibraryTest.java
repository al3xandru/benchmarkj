package org.mindstorms.benchmark.time.sys;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mindstorms.benchmark.time.ProcessTimesFunction;
import org.mindstorms.benchmark.time.ProcessTimesProvider;
import org.mindstorms.benchmark.time.Tms;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class LibraryTest {
  private ProcessTimesFunction m_function;

  @Before
  public void initializeLib() {
    m_function= ProcessTimesProvider.getProcessTimes();
  }
  
  @Test
  public void libraryLoad() {
    doSome2(100);
    Tms tms= m_function.getTms();

    assertNotNull("couldn't retrieve the times struct", tms);

    print(tms);
    for(int i= 0; i < 100; i++) {
      long sJ= System.currentTimeMillis();
      Tms sTms= m_function.getTms();

      System.out.println(doSome2(100000 + i));
      long eJ= System.currentTimeMillis();
      Tms eTms= m_function.getTms();
      print(sTms, eTms, sJ, eJ);
    }
  }

  private void print(Tms start, Tms stop, long millisStart, long millisStop) {
    System.out.println("------");
    print(start);
    print(stop);
    double result= stop.getUtime()- start.getUtime();
    System.out.println("UTime:" + (result) + " == " + (millisStop - millisStart) + " ms");
  }

  private void print(Tms tms) {
    System.out.println("Tms:" + tms);
  }

  private long doSome2(int maxCount) {
    long val= 0L;
    for(int i= 0; i < maxCount; i++) {
      for(int j= 0; j < 10000; j++) {
        val+= j;
      }
    }

    return val;
  }
}
