package com.linkedin.unnamedvariables;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExamplesUnnamedVariables {
    public static void safeDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException _) { /* intentionally ignored but documented */ }
    }

    public static void logAndDiscard(InputStream in) throws IOException {
        try (var _ = in) {                      // closes automatically; '_' not readable
            // consume without needing the variable name
            in.transferTo(OutputStream.nullOutputStream());
        }
    }

    public static void warmUp(int repetitions) {
        for (var _ : java.util.Collections.nCopies(repetitions, 0)) {
            spinOnce();
        }
    }

    private static void spinOnce() { /* ... */ }

}
