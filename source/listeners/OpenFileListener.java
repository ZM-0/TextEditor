package listeners;

import java.awt.event.ActionEvent;
import java.awt.FileDialog;
import java.io.IOException;
import main.TextEditor;

/**
 * A listener to handle events for the opening and creating of files.
 */
public class OpenFileListener extends MenuListener {
    /**
     * Creates a listener for the given editor.
     * @param editor The text editor being operated on.
     */
    public OpenFileListener(TextEditor editor) {
        super(editor);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Get user input to select the file, and then open or create the given file
        try {
            this.editor.openFile();
        } catch (IOException error) {
            System.exit(1);
        }

        this.editor.repaint();
    }
}
