package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
        String playerMove = currentPlayerMove.getCurrentMove();
        labelAIMove.setText(aiMove);
        switch (aiMove) {
            case Move.ROCK:
                switch (playerMove) {
                    case Move.PAPER:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                        break;
                    case Move.SCISSORS:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                        break;
                    default:
                        break;
                }
                break;
            case Move.PAPER:
                switch (playerMove) {
                    case Move.ROCK:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                        break;
                    case Move.SCISSORS:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                        break;
                    default:
                        break;
                }
                break;
            case Move.SCISSORS:
                switch (playerMove) {
                    case Move.ROCK:
                        labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
                        break;
                    case Move.PAPER:
                        labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
                        break;
                    default:
                        break;
                }
                break;
        }
        currentPlayerMove = null;
        labelSelectedMove.setText("");
        buttonPlayButton.setDisable(true);
    }
}
