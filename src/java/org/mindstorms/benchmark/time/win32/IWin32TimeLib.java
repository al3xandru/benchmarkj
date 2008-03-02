package org.mindstorms.benchmark.time.win32;

import com.sun.jna.Pointer;
import com.sun.jna.Library;

/**
 * Access process times on using Win32 API.
 *
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex the_mindstorm Popescu</a>
 * @since Mar 1, 2008
 */
public interface IWin32TimeLib extends Library {
    Pointer GetCurrentProcess();

    boolean GetProcessTimes(Pointer p, FileTime create, FileTime exit, FileTime kernel, FileTime user);
}
