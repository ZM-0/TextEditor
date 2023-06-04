package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;

/**
 * A class to handle the closing event of the main application frame.
 */
public class FrameListener extends WindowAdapter {
    /**
     * The frame being listened to.
     */
    private final Frame frame;

    /**
     * Creates a frame listener to listen to the given frame.
     * @param frame The frame to be listened to.
     */
    public FrameListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent event) {
        // TODO: Check if file has been saved or not
        this.frame.dispose();
        System.exit(0);
    }
}