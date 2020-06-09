package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

public class BishopPiece extends Piece{

    public BishopPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Bishop_"+color;
        direction = dir;
        String imgPath = PiecePath.BISHOP.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    @Override
    public void highlightPossibleTarget(Board board) {

    }
}
