package sample.background;

import javafx.scene.control.Control;
import sample.background.config.Direction;
import sample.background.config.Param;

import static sample.background.config.Param.PIECE_BLACK_COLOR;

public class CustomControl extends Control {

    private Board board;

    public CustomControl(){
        setSkin(new CustomSkinControl(this));
        Player player1 = new Player("ali", Direction.DOWN);
        Player player2 = new Player("mahdi", Direction.TOP);
        board = new Board(PIECE_BLACK_COLOR);//player one color;


        Game game = new Game(board, player1, player2);
        getChildren().add(board);

        setOnMouseClicked(e -> {
            game.selectPiece(e.getX(), e.getY());
        });
    }
}
