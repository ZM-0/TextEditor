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
        // Open the file dialog
        FileDialog fileDialog = this.editor.getFileDialog();
        fileDialog.setVisible(true);

        // Get the name of the selected file
        String filename = fileDialog.getFile();

        // Open or create the given file
        try {
            this.editor.openFile(filename);
        } catch (IOException error) {
            System.out.println("Failed to create file \"" + filename + "\"");
            System.exit(1);
        }

        this.editor.repaint();
    }
}
