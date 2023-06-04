package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a file being edited.
 */
public class EditorFile extends File {
    /**
     * Creates a file with the given pathname if it doesn't exist. If it does, it is effectively opened.
     * @param pathname The path to the file.
     * @throws IOException Thrown if the file couldn't be created.
     */
    public EditorFile(String pathname) throws IOException {
        super(pathname);

        if (!this.exists()) {
            this.createNewFile();
        }
    }

    /**
     * Reads the contents of the file.
     * @return The contents of the file as a string.
     * @throws IOException Thrown if the file couldn't be read.
     */
    public String read() throws IOException {
        char[] buffer = new char[(int) this.length()];  // Create a buffer to store the file contents

        FileReader fileReader = new FileReader(this);
        fileReader.read(buffer);
        fileReader.close();

        return new String(buffer);
    }

    /**
     * Writes the given text to the file.
     * @param text The text to be written to the file.
     * @throws IOException Thrown if the file couldn't be written.
     */
    public void write(String text) throws IOException {
        FileWriter fileWriter = new FileWriter(this);
        fileWriter.write(text);
        fileWriter.close();
    }
}
