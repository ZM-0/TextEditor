import java.awt.event.ActionEvent;
import java.awt.FileDialog;
import java.io.IOException;

public class NewFileListener extends MenuListener {
    /**
     * Creates a menu listener to listen to the given menu.
     * @param editor The text editor being operated on.
     * @param mainFrame The frame displaying the file.
     */
    public NewFileListener(TextEditor editor, MainFrame mainFrame) {
        super(editor, mainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Open the file dialog
        FileDialog fileDialog = this.mainFrame.getFileDialog();
        fileDialog.setVisible(true);

        // Create the given file
        String filename = fileDialog.getFile();

        try {
            this.editor.createFile(filename);
        } catch (IOException error) {
            System.out.println("Failed to create file \"" + filename + "\"");
            System.exit(1);
        }

        this.mainFrame.repaint();
    }
}
