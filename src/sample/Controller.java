package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.security.SecureRandom;

public class Controller {
    public Move currentPlayerMove = null;
    public ListView<Move> listMovesPlayable;
    public Label labelSelectedMove;
    public Label labelAIMove;
    public Label labelAIScore;
    public Label labelPlayerScore;
    public Button buttonPlayButton;

    public void initialize() {
        listMovesPlayable.getItems().add(new Move(Move.ROCK));
        listMovesPlayable.getItems().add(new Move(Move.PAPER));
        listMovesPlayable.getItems().add(new Move(Move.SCISSORS));
        buttonPlayButton.setDisable(true);
    }

    public void doSelectCurrentOption() {
        buttonPlayButton.setDisable(currentPlayerMove == null);
    }

    public void buttonDoSelectedCurrentSelectedMove(ActionEvent actionEvent) {
        currentPlayerMove = listMovesPlayable.getSelectionModel().getSelectedItem();
        buttonPlayButton.setDisable(false);
        labelSelectedMove.setText(currentPlayerMove.getCurrentMove());
    }

    public void buttonDoPlayAction(ActionEvent actionEvent) {
        SecureRandom secureRandom = new SecureRandom();
        String aiMove = listMovesPlayable.getItems().get(secureRandom.nextInt(3)).getCurrentMove();
        labelAIMove.setText(aiMove);
        switch (aiMove) {
            case Move.ROCK:
                System.out.println("AI plays rock.");
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.PAPER:
                        System.out.println("User plays paper.");
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.SCISSORS:
                        System.out.println("User plays scissors");
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                    default:
                        System.out.println("User plays rock or default.");
                        break;
                }
            case Move.PAPER:
                System.out.println("AI players paper.");
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.ROCK:
                        System.out.println("User plays rock.");
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.SCISSORS:
                        System.out.println("User plays scissors");
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                    default:
                        System.out.println("User plays paper or default.");
                        break;
                }
            case Move.SCISSORS:
                System.out.println("AI plays scissors.");
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.ROCK:
                        System.out.println("User plays rock.");
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.PAPER:
                        System.out.println("User plays paper.");
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    default:
                        System.out.println("User plays scissors or default.");
                        break;
                }
            default:
                System.out.println("Invalid.");
                break;
        }
        currentPlayerMove = null;
        labelSelectedMove.setText("");
        buttonPlayButton.setDisable(true);
    }
}
