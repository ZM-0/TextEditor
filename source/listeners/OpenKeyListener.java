package listeners;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import main.TextEditor;

/**
 * A listener to detect when Ctrl+O has been pressed to create or open a file.
 */
public class OpenKeyListener extends KeyAdapter {
    /**
     * The text editor.
     */
    private final TextEditor editor;

    /**
     * Creates a listener to listen for file keyboard saves on the given text editor.
     * @param editor The text editor.
     */
    public OpenKeyListener(TextEditor editor) {
        super();
        this.editor = editor;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.isControlDown() && event.getKeyCode() == KeyEvent.VK_O) {
            // Get user input to select the file, and then open or create the given file
            try {
                this.editor.openFile();
            } catch (IOException error) {
                System.exit(1);
            }

            this.editor.repaint();
        }
    }
}
