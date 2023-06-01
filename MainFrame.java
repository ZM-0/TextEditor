import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.Toolkit;

/**
 * The main application frame.
 */
public class MainFrame extends Frame {
    /**
     * The dialog to manage file accesses.
     */
    private final FileDialog fileDialog;

    /**
     * The single instance of the main frame.
     */
    private static MainFrame instance;

    /**
     * Constructs the main application frame.
     */
    private MainFrame() {
        super("Text Editor");

        this.fileDialog = new FileDialog(this);

        // Get the total screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int editorWidth = (int) screenSize.getWidth() / 2;
        int editorHeight = (int) screenSize.getHeight() / 2;
        int editorX = editorWidth / 2;
        int editorY = editorHeight / 2;

        this.addWindowListener(new FrameListener());

        this.setBounds(editorX, editorY, editorWidth, editorHeight);

        // Add the menus
        MenuBar menuBar = new MenuBar();
        menuBar.add(new FileMenu());

        this.setMenuBar(menuBar);

        this.add(new TextArea());
    }

    /**
     * Gets the single instance of this class, or creates it if it doesn't already exist.
     * @return The single instance of this class.
     */
    public static MainFrame getInstance() {
        if (null == MainFrame.instance) {
            MainFrame.instance = new MainFrame();
        }

        return MainFrame.instance;
    }

    /**
     * Gets the file dialog.
     * @return The file dialog.
     */
    public FileDialog getFileDialog() {
        return this.fileDialog;
    }
}
