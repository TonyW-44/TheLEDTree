import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberSequenceUI extends Application { // NumberSequenceUI uses Application abstract class

    private int[] sequences = {1, 2, 3}; // Array that stores each light sequence.
    // Numbers are placeholder for the sequence objects.
    private Label output = new Label();  // Creates label object that is used to output the array index as text
    // Not set since the output text is variable


    @Override
    public void start(Stage primaryStage) { // Method and sets up the JavaFX window
        primaryStage.setTitle("Select light sequence to play"); // Window title

        // Button objects to call array indexes
        Button sequence1Button = new Button("Sequence 1");
        Button sequence2Button = new Button("Sequence 2");
        Button sequence3Button = new Button("Sequence 3");

        // Objects that use method setOnAction that makes the button display the correct index from array "sequences"
        // !!! Need some way to abort the sequence once executed !!!
        // !!! Create number generator object to test cancel button !!!
        sequence1Button.setOnAction(e -> displaySequence(0));
        sequence2Button.setOnAction(e -> displaySequence(1));
        sequence3Button.setOnAction(e -> displaySequence(2));

        /* Vbox object. As I understand, Vbox is a container that will arrange the child (addAll) button vertically  */
        VBox vbox = new VBox(10); // 10 pixels specified between each button
        vbox.getChildren().addAll(sequence1Button, sequence2Button, sequence3Button, output);
        // adds the display label below the button for output to screen (they are in order descending)

        // Creates scene object that takes the vbox object and formats it to a size. Scene = the layout
        // within the window
        Scene scene = new Scene(vbox, 60, 150); // (40p W X 100p H)
        primaryStage.setScene(scene); // Not super clear on this, but it seems to tie everything together in
        // the code examples I studied

        primaryStage.show(); // Shows everything
    }

    private void displaySequence(int index) {
        // First line makes sure output is valid. Kinda like a catch exception except it heads off the issue.
        // "If the index is greater than or = to 0 and is an index and less than the array (sequences) length"
        //
        if (index >= 0 && index < sequences.length) {
            output.setText("Sequence " + sequences[index]);
            // Outputs the array index to screen in the displayLabel object - this can be used in the
            // future for other output
        } else {
            output.setText("Invalid Selection."); // JIC we add something that is not an index - for testing
        }
    }

}

// Not super sure how start and displaySequence get executed from main since
// I needed ChatGPT to figure out how to tie everything together - N.T.S. Ask Trevor