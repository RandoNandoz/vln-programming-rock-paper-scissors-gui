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

    public void buttonDoPlayAction(ActionEvent actionEvent) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        String aiMove = listMovesPlayable.getItems().get(secureRandom.nextInt(3)).getCurrentMove();
        String playerMove = currentPlayerMove.getCurrentMove();
        labelAIMove.setText(aiMove);
        if (aiMove.equals(Move.ROCK)) {
            if (playerMove.equals(Move.ROCK)) {
                return;
            } else if (playerMove.equals(Move.PAPER)) {
                labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
            } else if (playerMove.equals(Move.SCISSORS)) {
                labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
            } else {
                throw new Exception();
            }
        } else if (aiMove.equals(Move.PAPER)) {
            if (playerMove.equals(Move.ROCK)) {
                labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
            } else if (playerMove.equals(Move.PAPER)) {
                return;
            } else if (playerMove.equals(Move.SCISSORS)) {
                labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
            } else {
                throw new Exception();
            }
        } else if (aiMove.equals(Move.SCISSORS)) {
            if (playerMove.equals(Move.ROCK)) {
                labelPlayerScore.setText(String.valueOf(Integer.parseInt(labelPlayerScore.getText()) + 1));
            } else if (playerMove.equals(Move.PAPER)) {
                labelAIScore.setText(String.valueOf(Integer.parseInt(labelAIScore.getText()) + 1));
            } else if (playerMove.equals(Move.SCISSORS)) {
                return;
            } else return;
        }
        currentPlayerMove = null;
        labelSelectedMove.setText("");
        buttonPlayButton.setDisable(true);
    }
}
