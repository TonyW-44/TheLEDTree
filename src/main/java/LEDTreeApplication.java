import javax.swing.*;

public class LEDTreeApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LEDTreeApplication::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("My LEDTreeApplication"); // Creating the main window of the application
        JButton terminateButton = new JButton("Exit"); // Creating an exit button in the GUI
        terminateButton.addActionListener(e -> terminateApplication()); // Adds an actionListener to the button which is used for responding to user actions

        frame.getContentPane().add(terminateButton); // adds the button to the content pane which holds components that are visible in JFrame like buttons
        frame.setSize(300, 200); // set size of frame and can be changed to fit our project
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting default close operation if frame is closed
        frame.setVisible(true); // makes frame visible
    }

    public static void terminateApplication() {
        System.out.println("Terminate LEDTreeApplication");
        System.exit(0);
    }
}
