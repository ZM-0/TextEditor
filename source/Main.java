public class Main {
    /**
     * The main application entry-point method.
     * @param arguments Command-line arguments.
     */
    public static void main(String[] arguments) {
        TextEditor editor = TextEditor.getInstance();
        MainFrame mainFrame = new MainFrame(editor);
        mainFrame.setVisible(true);
    }
}
