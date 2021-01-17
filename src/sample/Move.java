package sample;

public class Move {
    public static final String ROCK = "Rock";
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";
    private final String currentMove;

    public Move(String currentMove) {
        this.currentMove = currentMove;
    }

    @Override
    public String toString() {
        return currentMove;
    }

    public String getCurrentMove() {
        return currentMove;
    }
}
