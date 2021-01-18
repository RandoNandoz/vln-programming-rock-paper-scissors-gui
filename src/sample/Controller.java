package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.security.SecureRandom;

public class Controller {
    public Move currentPlayerMove;
    public ListView<Move> listMovesPlayable;
    public Label labelSelectedMove;
    public Label labelAIMove;
    public Label labelAIScore;
    public Label labelPlayerScore;

    public void initialize() {
        listMovesPlayable.getItems().add(new Move(Move.ROCK));
        listMovesPlayable.getItems().add(new Move(Move.PAPER));
        listMovesPlayable.getItems().add(new Move(Move.SCISSORS));
    }

    public void doSelectCurrentOption() {

    }

    public void buttonDoSelectedCurrentSelectedMove(ActionEvent actionEvent) {
        currentPlayerMove = listMovesPlayable.getSelectionModel().getSelectedItem();
    }

    public void buttonDoPlayAction(ActionEvent actionEvent) {
        SecureRandom secureRandom = new SecureRandom();
        String aiMove = listMovesPlayable.getItems().get(secureRandom.nextInt(3)).getCurrentMove();
        labelAIMove.setText(aiMove);
        switch (aiMove) {
            case Move.ROCK:
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.PAPER:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.SCISSORS:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText() + 1)));
                    default:
                        break;
                }
            case Move.PAPER:
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.ROCK:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.SCISSORS:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                    default:
                        break;
                }
            case Move.SCISSORS:
                switch (currentPlayerMove.getCurrentMove()) {
                    case Move.ROCK:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    case Move.PAPER:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                    default:
                        break;
                }
            default:
                break;
        }
    }
}
