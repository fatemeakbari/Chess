package sample.background.pieces;


import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

public class QueenPiece extends Piece {

    public QueenPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Queen_"+color;
        direction = dir;
        String imgPath = PiecePath.QUEEN.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    @Override
    public void highlightPossibleTarget(Board board) {
        RookPiece rookPiece = new RookPiece(x,y,direction);
        rookPiece.highlightPossibleTarget(board);
        BishopPiece bishopPiece = new BishopPiece(x,y,direction);
        bishopPiece.highlightPossibleTarget(board);
    }
}
