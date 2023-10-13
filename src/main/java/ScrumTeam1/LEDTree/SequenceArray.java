package ScrumTeam1.LEDTree;

public class SequenceArray {
    // !!!Class used for storing the array of sequences!!!

    private int[] sequences; // Array that stores each light sequence.


    public SequenceArray() {
        sequences = new int[]{1, 2, 3}; // Initializes the array with placeholders.
        // I'm not sure how to implement the actual sequences yet though.
    }

    // Loop that iterates over the array to find an index value.
    // "Index must be greater than or equal to 0 and no higher then the array length
    public int getIndex (int index) {
        if (index >= 0 && index < sequences.length) {
            return sequences[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int getArrayLength() {
        return sequences.length;
    }

}
