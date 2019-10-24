package bashpro.pty4j.unix;

import com.pty4j.PtyProcess;
import com.pty4j.WinSize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author traff
 */
public interface PtyExecutor {
  int execPty(String full_path, String[] argv, String[] envp,
              String dirpath, String pts_name, int fdm, String err_pts_name, int err_fdm, boolean console,
              String add_pts_name, int add_pty_fdm);

  int waitForProcessExitAndGetExitCode(int pid);

  @NotNull WinSize getWindowSize(int fd, @Nullable PtyProcess process) throws UnixPtyException;

  void setWindowSize(int fd, @NotNull WinSize winSize, @Nullable PtyProcess process) throws UnixPtyException;
}