package main;

import listeners.MenuListener;
import listeners.OpenFileListener;
import listeners.SaveFileListener;
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
     * Constructs the file menu.
     * @param editor The text editor the menu is on.
     */
    public FileMenu(TextEditor editor) {
        super("File");
        this.editor = editor;

        // Add the menu items
        this.addItem("Create/Open File", new OpenFileListener(editor));
        this.addItem("Save File", new SaveFileListener(editor));
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
