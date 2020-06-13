package sample.background.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class PawnPiece extends Piece {


    public PawnPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Pawn_"+color;
        direction = dir;
        String imgPath = PiecePath.PAWN.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }



    @Override
    public void highlightPossibleTarget(Board board) {

        int dir = direction.getDir();
        if(validRange(y+dir))
        {
            if(!board.getTiles()[x][y+dir].hasPiece()){
                board.getTiles()[x][y+dir].highLight(TARGET_TILE_COLOR);
            }
            if(firstMove){
                if(!(board.getTiles()[x][y+dir].hasPiece() || board.getTiles()[x][y+2*dir].hasPiece())){
                    board.getTiles()[x][y+2*dir].highLight(TARGET_TILE_COLOR);
                }
            }

            if(validRange(x+1)){
                if((board.getTiles()[x+1][y+dir].hasPiece())){
                    if(!board.getTiles()[x+1][y+dir].getPiece().getDirection().equals(direction)){
                        board.getTiles()[x+1][y+dir].highLight(TARGET_TILE_COLOR);
                    }
                }
            }

            if(validRange(x-1))
            {
                if((board.getTiles()[x-1][y+dir].hasPiece())){
                    if(!board.getTiles()[x-1][y+dir].getPiece().getDirection().equals(direction)){
                        board.getTiles()[x-1][y+dir].highLight(TARGET_TILE_COLOR);
                    }
                }
            }
        }
    }
}
