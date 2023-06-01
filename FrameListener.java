import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A class to handle the closing event of the main application frame.
 */
public class FrameListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent event) {
        MainFrame.getInstance().dispose();
        System.exit(0);
    }
}