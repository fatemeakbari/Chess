package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class KnightPiece extends Piece {

    public KnightPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Knight_"+color;
        direction = dir;
        String imgPath = PiecePath.KNIGHT.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    private void helpFindTarget(Tile tile){
        if(tile.hasPiece()){
            if(!tile.getPiece().getDirection().equals(direction)){
                tile.highLight(TARGET_TILE_COLOR);
            }
            return;
        }
        tile.highLight(TARGET_TILE_COLOR);

    }
    @Override
    public void highlightPossibleTarget(Board board) {

        if(validRange(x+1,y+2)){
            helpFindTarget(board.getTiles()[x+1][y+2]);
        }
        if(validRange(x+2,y+1)){
            helpFindTarget(board.getTiles()[x+2][y+1]);
        }
        if(validRange(x-1,y+2)){
            helpFindTarget(board.getTiles()[x-1][y+2]);
        }
        if(validRange(x-2,y+1)){
            helpFindTarget(board.getTiles()[x-2][y+1]);
        }

        if(validRange(x+1,y-2)){
            helpFindTarget(board.getTiles()[x+1][y-2]);
        }
        if(validRange(x+2,y-1)){
            helpFindTarget(board.getTiles()[x+2][y-1]);
        }
        if(validRange(x-1,y-2)){
            helpFindTarget(board.getTiles()[x-1][y-2]);
        }
        if(validRange(x-2,y-1)){
            helpFindTarget(board.getTiles()[x-2][y-1]);
        }
        }
}
