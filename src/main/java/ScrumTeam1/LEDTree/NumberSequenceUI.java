package ScrumTeam1.LEDTree;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class NumberSequenceUI extends Application {

    // This Text object is used to output the array index as text
    // It's not set initially with text since the output text is variable
    private Text output = new Text();

    // This object is created out of the SequenceArray class where the Sequences
    // are stored in an array
    private SequenceArray sA = new SequenceArray();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The LED Tree!"); // Top windows bar text

        //Button objects with their associated display text.
        // Uses the method "createStyledButton" to consolidate format parameters and create the buttons - see below
        // !!! Need to add cancel sequence button !!!
        Button sequence1Button = createStyledButton("Sequence 1", "white");
        Button sequence2Button = createStyledButton("Sequence 2", "white");
        Button sequence3Button = createStyledButton("Sequence 3", "white");
        //Button cancelSequenceButton = createStyledButton("Cancel Sequence");
        Button exitAppButton = createStyledButton("Exit", "white");

        // Sets what each button does -  pull up "sequence" from array, or close program
        sequence1Button.setOnAction(e -> displaySequence(0));
        sequence2Button.setOnAction(e -> displaySequence(1));
        sequence3Button.setOnAction(e -> displaySequence(2));
        //cancelSequenceButton.setOnAction((e -> cancelSequence()));
        exitAppButton.setOnAction(e -> System.exit(0));

        // Sets layout of the window
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20)); // Padding for between display objects

        // Add the text box at the top with the specified text
        Text instructionText = new Text("Please choose a sequence to execute.");
        instructionText.setStyle("-fx-font-size: 16; -fx-font-weight: 600; -fx-padding: 0 0 10 0;");

        // Create a StackPane for the instruction text section
        StackPane instructionPane = new StackPane(instructionText);
        // Set styles for the instructionPane to have a white background, a black border, 2 pixels wide
        // and some padding to separate text from the border
        instructionPane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2; -fx-padding: 2;");
        instructionPane.setAlignment(instructionText, javafx.geometry.Pos.CENTER); // Sets position of the text box

        grid.add(instructionPane, 0, 0, 4, 1); // Spanning 4 columns

        // Adds the sequence buttons to coordinates within the grid
        grid.add(sequence1Button, 0, 1); // Column 0, row 1
        grid.add(sequence2Button, 0, 2); // C0, r2
        grid.add(sequence3Button, 0, 3); // C0, row3
        grid.add(exitAppButton, 3, 1); // etc.

        // Create a StackPane for the output section
        StackPane outputPane = new StackPane(output);
        // Set styles for the outputPane to have a white background, a black border, 2 pixels wide
        // and some padding to separate text from the border
        outputPane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2; -fx-padding: 5;");
        outputPane.setAlignment(output, javafx.geometry.Pos.CENTER);

        grid.add(outputPane, 0, 4, 4, 1); // Spanning 4 columns, placed in column 0 row 4

        // Load the background image
        Image backgroundImage = new Image("file:src/main/Images/ChristmasLightsImage.jpg"); // Background image directory - note: must use "file" keyword
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        Background backgroundWithImage = new Background(background);
        grid.setBackground(backgroundWithImage);

        // Ties everything together as a scene object.
        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Method used to display the correct sequence number
    // Calls the index directly from the button.
    // The button uses the getIndex method to set and call the correct value
    // Included a catch in case I modify this in the future and the index is out of bounds
    private void displaySequence(int index) {
        try {
            String sequenceValue = sA.getObjIndex(index);
            output.setText(sequenceValue);
            output.setFill(Color.BLACK);
        } catch (IllegalArgumentException e) {
            output.setText("Invalid Selection: " + e.getMessage());
            output.setFill(Color.RED);
        }
    }

    // Method for centralizing the styling of the buttons, used above to create the buttons
    private Button createStyledButton(String text, String backgroundColor) {
        Button button = new Button(text); // Creates a button object.
        // Calls setStyle method from button class with parameters
        button.setStyle("-fx-font-size: 14; -fx-font-weight: BOLD; -fx-padding: 10 20; -fx-background-color: " + backgroundColor + ";");
        return button;
    }


}

