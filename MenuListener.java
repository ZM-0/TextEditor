import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * A class to handle actions on the menu items.
 */
public class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());

        if (Objects.equals(event.getActionCommand(), "New File")) {
            MainFrame.getInstance().getFileDialog().setVisible(true);
        }
    }
}