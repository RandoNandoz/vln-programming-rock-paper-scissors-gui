package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

public class Controller {
    public Move currentPlayerMove;
    public ListView<Move> listMovesPlayable;

    public void initialize() {
        listMovesPlayable.getItems().add(new Move(Move.ROCK));
        listMovesPlayable.getItems().add(new Move(Move.PAPER));
        listMovesPlayable.getItems().add(new Move(Move.SCISSORS));
    }

    public void doSelectCurrentOption() {
        listMovesPlayable.getSelectionModel().getSelectedItem();
        
    }

    public void buttonDoSelectedCurrentSelectedMove(ActionEvent actionEvent) {

    }
}
