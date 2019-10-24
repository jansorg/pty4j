package bashpro.pty4j;

import bashpro.pty4j.unix.Pty;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author jansorg
 */
public interface AdditionalPtyProcess {
    String PTY_PLACEHOLDER = "_DBG_PTY_";

    @Nullable
    Pty getAdditionalPty();

    @Nullable
    InputStream getAdditionalPtyInputStream();

    @Nullable
    OutputStream getAdditionalPtyOutputStream();
}
