import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.Toolkit;
import java.util.Objects;

/**
 * The main application frame.
 */
public class MainFrame extends Frame {
    /**
     * The dialog to manage file accesses.
     */
    private final FileDialog fileDialog;

    /**
     * The component displaying the text.
     */
    private final TextComponent textComponent;

    /**
     * The text editor being displayed in this frame.
     */
    private final TextEditor editor;

    /**
     * Constructs the main application frame.
     * @param editor The text editor being displayed.
     */
    public MainFrame(TextEditor editor) {
        super("Text Editor");

        this.fileDialog = new FileDialog(this);
        this.textComponent = new TextArea();
        this.add(this.textComponent);
        this.editor = editor;

        // Get the total screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Find the size and position of the frame
        int editorWidth = (int) screenSize.getWidth() / 2;
        int editorHeight = (int) screenSize.getHeight() / 2;
        int editorX = editorWidth / 2;
        int editorY = editorHeight / 2;

        // Set the frame size and position
        this.setBounds(editorX, editorY, editorWidth, editorHeight);

        // Add a listener to close this frame
        this.addWindowListener(new FrameListener(this));

        // Add the menus
        MenuBar menuBar = new MenuBar();
        menuBar.add(new FileMenu(this.editor, this));
        this.setMenuBar(menuBar);
    }

    /**
     * Gets the file dialog.
     * @return The file dialog.
     */
    public FileDialog getFileDialog() {
        return this.fileDialog;
    }

    /**
     * Gets the text input for the file.
     * @return The file contents in the editor.
     */
    public String getText() {
        return this.textComponent.getText();
    }

    /**
     * Sets the text displayed for the file.
     * @param text The text to be displayed.
     */
    public void setText(String text) {
        this.textComponent.setText(text);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        // Update the frame title
        String filename = this.editor.getFileName();

        if (Objects.equals(filename, "")) {
            this.setTitle("Text Editor");
        } else {
            this.setTitle("Text Editor - " + filename);
        }

        // Update the file text
        this.textComponent.setText(this.editor.getText());
    }
}
