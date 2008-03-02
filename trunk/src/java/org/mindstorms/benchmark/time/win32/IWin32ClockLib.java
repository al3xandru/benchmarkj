package org.mindstorms.benchmark.time.win32;

import com.sun.jna.NativeLong;
import com.sun.jna.Library;

/**
 * Access clock system call on win32.
 *
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex the_mindstorm Popescu</a>
 * @since Mar 1, 2008
 */
public interface IWin32ClockLib extends Library {
    NativeLong clock();
}
