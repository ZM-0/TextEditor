import java.awt.Menu;
import java.awt.MenuItem;

/**
 * The file menu on the text editor.
 */
public class FileMenu extends Menu {
    /**
     * The text editor to be operated on during events.
     */
    protected final TextEditor editor;

    /**
     * The frame displaying the file.
     */
    protected final MainFrame mainFrame;

    /**
     * Constructs the file menu.
     */
    public FileMenu(TextEditor editor, MainFrame mainFrame) {
        super("File");
        this.editor = editor;
        this.mainFrame = mainFrame;

        // Add the menu items
        this.addItem("New File", new NewFileListener(editor, mainFrame));
        this.addItem("Save File", new SaveFileListener(editor, mainFrame));
//        this.addItem("Open File");
    }

    /**
     * Adds an item to the menu with the given command string.
     * @param command The command string for the new item.
     * @param listener The listener to process this command.
     */
    private void addItem(String command, MenuListener listener) {
        MenuItem item = new MenuItem(command);
        item.setActionCommand(command);
        item.addActionListener(listener);
        this.add(item);
    }
}
