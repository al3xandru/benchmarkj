package org.mindstorms.benchmark;

import java.io.StringWriter;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
* @since Mar 1, 2008
*/
public class DummyJob implements Runnable {
  private StringWriter sw= new StringWriter();
  
  public void run() {
    long val = 0L;
    for(int i = 0; i < 10000; i++) {
      for(int j = 0; j < 10000; j++) {
        val += j;
      }
    }

    sw.write("" + val);
  }

  public StringBuffer getOutput() {
    return sw.getBuffer();
  }
}
