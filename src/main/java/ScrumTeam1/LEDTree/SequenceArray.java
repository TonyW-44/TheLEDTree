package ScrumTeam1.LEDTree;

public class SequenceArray {
    // !!!Class used for storing the array of sequences!!!

    private int[] sequences; // Array that stores test int.

    private Sequence[] objSeq; // Array that stores the actual light sequence objects

    // The 3 sequences objects to be used
    Sequence seq1 = new Sequence1();
    Sequence seq2 = new Sequence2();
    Sequence seq3 = new Sequence3();
    LEDColorController actualLightSequence = new LEDColorController();


    public SequenceArray() {
        sequences = new int[]{1, 2, 3, 4}; // Initializes the array with placeholders.
        // I'm not sure how to implement the actual sequences yet though.

        objSeq = new Sequence[]{seq1, seq2, seq3, (Sequence) actualLightSequence};
    }

    // Loop that iterates over the test array to find an index value.
    // "Index must be greater than or equal to 0 and no higher then the array length
    public int getIndex (int index) {
        if (index >= 0 && index < sequences.length) {
            return sequences[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Loop that iterates over the actual sequence array to find an index value.

    // Depreciated old method
    public String getObjIndex(int index) {
        if (index >= 0 && index < objSeq.length) {
            return objSeq[index].getStringValue();
        }
        throw new IllegalArgumentException("Invalid Selection: Index out of bounds");
    }

    public void getObjIndexShutdown() {
        actualLightSequence.shutdown();
    }

    // New method that uses conditionals to return two object types for the array
    public String getObjIndex(int index) throws InterruptedException {
        Object sequenceObj = getIndex(index);
        if (sequenceObj instanceof Sequence) {
            return ((Sequence) sequenceObj).getStringValue();
        } else if (sequenceObj instanceof LEDColorController) {
            ((LEDColorController) sequenceObj).runColorSequence(20, 2, 1);
            return "LED Sequence Cancelled";
        } else {
            throw new IllegalArgumentException("Invalid Selection: Index out of bounds");
        }
    }

}
