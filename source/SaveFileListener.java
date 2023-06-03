import java.awt.event.ActionEvent;
import java.io.IOException;

public class SaveFileListener extends MenuListener {
    /**
     * Creates a menu listener to listen to the given menu.
     * @param editor The text editor being operated on.
     * @param mainFrame The frame displaying the file.
     */
    public SaveFileListener(TextEditor editor, MainFrame mainFrame) {
        super(editor, mainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.editor.setText(this.mainFrame.getText());

        try {
            this.editor.save();
        } catch (IOException error) {
            error.printStackTrace();
        }

        this.mainFrame.repaint();
    }
}
