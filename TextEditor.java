import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEditor {
    /**
     * The main application frame.
     */
    private final Frame frame;

    /**
     * The single instance of this class.
     */
    private static TextEditor instance;

    /**
     * A private constructor to enforce the singleton pattern.
     * Constructs a new text editor frame.
     */
    private TextEditor() {
        this.frame = new Frame("Text Editor");

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int editorWidth = (int) screenSize.getWidth() / 2;
        int editorHeight = (int) screenSize.getHeight() / 2;
        int editorX = editorWidth / 2;
        int editorY = editorHeight / 2;

        this.frame.addWindowListener(new TextEditorFrameListener());

        this.frame.setBounds(editorX, editorY, editorWidth, editorHeight);
    }

    /**
     * A static method to get the single instance of this class.
     * @return The single instance of this class.
     */
    public static TextEditor getInstance() {
        if (null == TextEditor.instance) {
            TextEditor.instance = new TextEditor();
        }

        return TextEditor.instance;
    }

    /**
     * The main application entry-point method.
     * @param arguments Command-line arguments.
     */
    public static void main(String[] arguments) {
        TextEditor editor = TextEditor.getInstance();
        editor.frame.setVisible(true);
    }

    /**
     * A class to handle the closing event of the main frame.
     */
    private static class TextEditorFrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent event) {
            TextEditor.getInstance().frame.dispose();
            System.exit(0);
        }
    }
}
