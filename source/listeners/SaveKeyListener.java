package listeners;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import main.TextEditor;

/**
 * A listener to detect when Ctrl+S has been pressed to save the file.
 */
public class SaveKeyListener extends KeyAdapter {
    /**
     * The text editor.
     */
    private final TextEditor editor;

    /**
     * Creates a listener to listen for file keyboard saves on the given text editor.
     * @param editor The text editor.
     */
    public SaveKeyListener(TextEditor editor) {
        super();
        this.editor = editor;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_S) {
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
}
