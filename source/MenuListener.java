import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class to handle actions on the menu items.
 */
public class MenuListener implements ActionListener {
    /**
     * The text editor to be operated on during events.
     */
    protected final TextEditor editor;

    /**
     * The frame displaying the file.
     */
    protected final MainFrame mainFrame;

    /**
     * Creates a menu listener to listen to the given menu.
     * @param editor The text editor being operated on.
     * @param mainFrame The frame displaying the file.
     */
    public MenuListener(TextEditor editor, MainFrame mainFrame) {
        this.editor = editor;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
    }
}