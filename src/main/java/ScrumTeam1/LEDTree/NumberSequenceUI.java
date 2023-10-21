package ScrumTeam1.LEDTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberSequenceUI extends Application { // NumberSequenceUI uses Application abstract class
    // !!!This class houses the JavaFX UI!!!

    private Label output = new Label();  // Creates label object that is used to output the array index as text
    // Not set since the output text is variable
    SequenceArray sA = new SequenceArray(); // Creates object out of class SequenceArray where the Sequences
    // are stored in an array

    @Override
    public void start(Stage primaryStage) { // Method and sets up the JavaFX window
        primaryStage.setTitle("Select light sequence to play"); // Window title

        // Button objects to call array indexes
        Button sequence1Button = new Button("Sequence 1");
        Button sequence2Button = new Button("Sequence 2");
        Button sequence3Button = new Button("Sequence 3");
        Button exitAppButton = new Button("Exit");

        /* Objects that use method setOnAction that makes the button display the correct index from array "sequences"
        using the getIndex method from instantiated object sA ("SequenceArray")
         */
        // !!! Need some way to abort the sequence once executed !!!
        // !!! Create number generator object to test cancel button !!!
        sequence1Button.setOnAction(e -> displaySequence(0));
        sequence2Button.setOnAction(e -> displaySequence(1));
        sequence3Button.setOnAction(e -> displaySequence(2));
        exitAppButton.setOnAction(e -> System.exit(0));

        /* Vbox object. As I understand, Vbox is a container that will arrange the child (addAll) button vertically  */
        VBox vbox = new VBox(10); // 10 pixels specified between each button
        vbox.getChildren().addAll(sequence1Button, sequence2Button, sequence3Button, exitAppButton, output);
        // adds the display label below the button for output to screen (they are in order descending)

        // Creates scene object that takes the vbox object and formats it to a size. Scene = the layout
        // within the window
        Scene scene = new Scene(vbox, 60, 200); // (40p W X 100p H)
        primaryStage.setScene(scene); // Not super clear on this, but it seems to tie everything together in
        // the code examples I studied

        primaryStage.show(); // Shows everything
    }

    // Method used to display the correct sequence number. Calls the index directly from the button.
    //The button uses the getIndex method to set and call the correct value
    //Included a catch in case I modify this in the future and the index is out of bounds
    private void displaySequence(int index) {
        try {
            String sequenceValue = sA.getObjIndex(index);
            output.setText(sequenceValue);
        } catch (IllegalArgumentException e) {
            output.setText("Invalid Selection: " + e.getMessage());
        }
    }

}
