package listeners;

import java.awt.event.ActionListener;
import main.TextEditor;

/**
 * A base class for listeners on the menus of the text editor.
 */
public abstract class MenuListener implements ActionListener {
    /**
     * The text editor to be operated on during events.
     */
    protected final TextEditor editor;

    /**
     * Creates a listener for the given editor.
     * @param editor The text editor being operated on.
     */
    public MenuListener(TextEditor editor) {
        this.editor = editor;
    }
}