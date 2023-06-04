package listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;
import main.TextEditor;

/**
 * A listener to handle events for saving the current editor file.
 */
public class SaveFileListener extends MenuListener {
    /**
     * Creates a listener for the given editor.
     * @param editor The text editor being operated on.
     */
    public SaveFileListener(TextEditor editor) {
        super(editor);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Update the file with the unsaved editor text
        try {
            this.editor.saveFile();
        } catch (IOException error) {
            error.printStackTrace();
            System.exit(1);
        }

        this.editor.repaint();
    }
}
