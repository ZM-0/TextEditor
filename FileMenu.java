import java.awt.event.ActionListener;
import java.awt.Menu;
import java.awt.MenuItem;

/**
 * The file menu on the text editor.
 */
public class FileMenu extends Menu {
    /**
     * The listener for events on this menu.
     */
    private final ActionListener menuListener;

    /**
     * Constructs the file menu.
     */
    public FileMenu() {
        super("File");

        this.menuListener = new MenuListener();

        // Add the menu items
        this.addItem("New File");
        this.addItem("Open File");
        this.addItem("Save File");
    }

    /**
     * Adds an item to the menu with the given command string.
     * @param command The command string for the new item.
     */
    private void addItem(String command) {
        MenuItem item = new MenuItem(command);
        item.setActionCommand(command);
        item.addActionListener(this.menuListener);
        this.add(item);
    }
}
