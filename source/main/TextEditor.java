package main;

import listeners.FrameListener;
import listeners.OpenKeyListener;
import listeners.SaveKeyListener;
import listeners.TextEditListener;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * The text-editor application and the main application frame. It can work with one file at a time.
 */
public class TextEditor extends Frame {
    /**
     * The dialog to manage file accesses.
     */
    private final FileDialog fileDialog;

    /**
     * The component displaying the text.
     */
    private final TextComponent textComponent;

    /**
     * The file being edited.
     */
    private EditorFile file;

    /**
     * The status of the editor.
     */
    private EditorStatus status;

    /**
     * Constructs the main application frame.
     */
    public TextEditor() {
        super("Text Editor");

        // Set up the fields
        this.fileDialog = new FileDialog(this);
        this.textComponent = new TextArea();
        this.textComponent.addKeyListener(new OpenKeyListener(this));
        this.textComponent.addKeyListener(new SaveKeyListener(this));
        this.textComponent.addTextListener(new TextEditListener(this));
        this.add(this.textComponent);
        this.file = null;
        this.setStatus(EditorStatus.NO_FILE);

        // Set up the frame size and position
        this.setupBounds();

        // Add a listener to close this frame
        this.addWindowListener(new FrameListener(this));

        // Add the menus
        MenuBar menuBar = new MenuBar();
        menuBar.add(new FileMenu(this));
        this.setMenuBar(menuBar);
    }

    /**
     * Gets user input for the file to be opened or created.
     * Opens the file if it exists, or creates a new file if it doesn't exist.
     * The new file is displayed in the editor.
     * @throws IOException Thrown if the file couldn't be made.
     */
    public void openFile() throws IOException {
        // Open the file dialog
        this.fileDialog.setVisible(true);

        // Get the name of the selected file
        String pathname = this.fileDialog.getFile();

        // Open or create the file
        this.file = new EditorFile(pathname);
        this.setText(this.file.read());
    }

    /**
     * Saves the current editor text to the current file.
     * @throws IllegalStateException Thrown if the current file is null or doesn't exist.
     * @throws IOException Thrown if the file couldn't be written to.
     */
    public void saveFile() throws IllegalStateException, IOException {
        if (null == this.file || !this.file.exists()) {
            throw new IllegalStateException("No valid file to save");
        }

        this.file.write(this.getText());
        this.setStatus(EditorStatus.SAVED);
    }

    /**
     * Gets the file dialog.
     * @return The file dialog.
     */
    public FileDialog getFileDialog() {
        return this.fileDialog;
    }

    /**
     * Gets the status of the editor.
     * @return The current editor state.
     */
    public EditorStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the editor status.
     * @param status The new editor status.
     */
    public void setStatus(EditorStatus status) {
        this.status = status;
    }

    /**
     * Gets the text input for the file.
     * @return The file contents in the editor.
     */
    private String getText() {
        return this.textComponent.getText();
    }

    /**
     * Sets the text displayed for the file.
     * @param text The text to be displayed.
     */
    private void setText(String text) {
        this.textComponent.setText(text);
    }

    /**
     * Sets up the frame size and position.
     */
    private void setupBounds() {
        // Get the total screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the size and position of the frame
        int editorWidth = (int) screenSize.getWidth() / 2;
        int editorHeight = (int) screenSize.getHeight() / 2;
        int editorX = editorWidth / 2;
        int editorY = editorHeight / 2;

        // Set the frame size and position
        this.setBounds(editorX, editorY, editorWidth, editorHeight);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        // Update the frame title
        if (null == this.file) {
            this.setTitle("Text Editor");
        } else {
            String title = "Text Editor - " + this.file.getName();

            if (this.getStatus() != EditorStatus.SAVED) {
                title = title.concat("*");
            }

            this.setTitle(title);
        }
    }
}
