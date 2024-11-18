package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    public static final String HOME = System.getProperty("user.home");
    public static final String DEFAULT_FILE = "output.txt";
    File curruntFile = new File(HOME + File.separator + DEFAULT_FILE);

    public void setCurrentFile(final File file) {
        if ((file.exists()) && (file.isFile())) {
            curruntFile = file;
        } else {
            throw new IllegalArgumentException("file not exist");
        }
    }

    public File getCurrentFile() {
        return curruntFile;
    }

    public String getCurrentPath() {
        return curruntFile.getAbsolutePath();
    }  

    public void saveString(final String string) throws IOException{
        try (PrintStream ps = new PrintStream(curruntFile, StandardCharsets.UTF_8)) {
            ps.println(string);
        }
    }
}
