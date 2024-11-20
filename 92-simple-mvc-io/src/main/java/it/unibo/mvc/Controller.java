package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File curruntFile = new File(System.getProperty("user.home"), "output.txt");

    /**
     * set a new destination file.
     * 
     * @param file
     */
    public void setCurrentFile(final File file) {
        if (file.exists() && file.isFile()) {
            curruntFile = file;
        } else {
            throw new IllegalArgumentException("file not exist");
        }
    }

    /**
     * 
     * @return currentFile.
     */
    public File getCurrentFile() {
        return curruntFile;
    }

    /**
     * 
     * @return path of currentFile.
     */
    public String getCurrentPath() {
        return curruntFile.getAbsolutePath();
    }

    /**
     * save the text.
     * 
     * @param string
     *text to save.
     * @throws IOException
     *if the writing fail.
     */
    public void saveString(final String string) throws IOException {
        try (PrintStream ps = new PrintStream(curruntFile, StandardCharsets.UTF_8)) {
            ps.println(string);
        }
    }
}
