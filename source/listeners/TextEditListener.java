package listeners;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import main.EditorStatus;
import main.TextEditor;

/**
 * A listener to detect when the file has been edited.
 */
public class TextEditListener implements TextListener {
    /**
     * The text editor.
     */
    private final TextEditor editor;

    /**
     * Creates a listener to listen for file edits on the given text editor.
     * @param editor The text editor.
     */
    public TextEditListener(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void textValueChanged(TextEvent event) {
        if (this.editor.getStatus() != EditorStatus.NO_FILE) {
            this.editor.setStatus(EditorStatus.UNSAVED);
        } else {
            this.editor.setStatus(EditorStatus.SAVED);
        }

        this.editor.repaint();
    }
}
