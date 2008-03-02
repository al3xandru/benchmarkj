package org.mindstorms.benchmark.time.sys;

import com.sun.jna.Library;
import com.sun.jna.NativeLong;

/**
 * Access process time system calls on OSes with sys/times.h.
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public interface ISysTimesLib extends Library {
  /**
   * clock_t times(struct tms *)
   * <p/>
   * <code>clock_t</code> must be mapped to <code>NativeLong</code> as
   * it is a long int (and so it has to deal with 32b and 64b).
   * 
   * @param tms a structure containing the different times
   * @return
   */
  NativeLong times(TmsStruct tms);

  long sysconf(int name);

//  NativeLong clock();  
}
