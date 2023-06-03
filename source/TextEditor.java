import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * The text-editor application. It can work with one file at a time.
 */
public class TextEditor {
    /**
     * The file being worked on.
     */
    private File file;

    /**
     * The text being displayed.
     */
    private String text;

    /**
     * The single instance of the editor.
     */
    private static TextEditor instance;

    /**
     * Creates a text editor with no file.
     */
    private TextEditor() {
        this.file = null;
        this.text = "";
    }

    /**
     * A static method to access the single instance.
     * @return The single text editor object.
     */
    public static TextEditor getInstance() {
        if (null == TextEditor.instance) {
            TextEditor.instance = new TextEditor();
        }

        return TextEditor.instance;
    }

    /**
     * Creates a new file with the given filename if it doesn't exist. The new file is displayed in the editor.
     * @param filename The name of the new file.
     * @throws IOException Thrown if the file couldn't be made.
     */
    public void createFile(String filename) throws IOException {
        this.file = new File(filename);
        this.file.createNewFile();
        this.readFile(this.file);
    }

    /**
     * Opens a file to be edited on.
     * @param filename The name of the file.
     * @throws IllegalStateException Thrown if the file doesn't exist.
     * @throws IOException Thrown if the file couldn't be read.
     */
    public void openFile(String filename) throws IllegalStateException, IOException {
        File file = new File(filename);

        if (!file.exists()) {
            throw new IllegalStateException("File doesn't exist");
        }

        this.file = file;
        this.readFile(this.file);
    }

    /**
     * Saves the current editor text to the current file.
     * @throws IllegalStateException Thrown if the current file is null or doesn't exist.
     * @throws IOException Thrown if the file couldn't be written to.
     */
    public void save() throws IllegalStateException, IOException {
        if (null == this.file || !this.file.exists()) {
            throw new IllegalStateException("No valid file to save");
        }

        FileWriter fileWriter = new FileWriter(this.file);
        fileWriter.write(this.text);
        fileWriter.close();
    }

    /**
     * Reads the text in the given file into the text editor.
     * @param file The file to be read.
     * @throws FileNotFoundException Thrown if the file doesn't exist.
     * @throws IOException Thrown if the file couldn't be read.
     */
    private void readFile(File file) throws FileNotFoundException, IOException {
        char[] buffer = new char[(int) file.length()];

        FileReader fileReader = new FileReader(file);
        fileReader.read(buffer);
        fileReader.close();

        this.text = Arrays.toString(buffer);
    }

    /**
     * Gets the name of the current file.
     * @return The name of the current file, or an empty string if the file is null.
     */
    public String getFileName() {
        return null == this.file ? "" : this.file.getName();
    }

    /**
     * Gets the text.
     * @return The current file text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Sets the text.
     * @param text The new file text.
     */
    public void setText(String text) {
        this.text = text;
    }
}
