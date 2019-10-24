package com.pty4j;

import com.pty4j.unix.Pty;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author jansorg
 */
public interface AdditionalPtyProcess {
    @Nullable
    Pty getAdditionalPty();

    @Nullable
    InputStream getAdditionalPtyInputStream();

    @Nullable
    OutputStream getAdditionalPtyOutputStream();
}
