package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class KingPiece extends Piece {

    public KingPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "King_"+color;
        direction = dir;
        String imgPath = PiecePath.KING.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }


    @Override
    public void highlightPossibleTarget(Board board) {
        for(int row=x-1;row<=x+1;row++){
            for(int col=y-1;col<=y+1;col++){

                if(!(row == x && col == y) && validRange(row,col)){

                    Tile tile = board.getTiles()[row][col];

                    if(tile.hasPiece()){
                        if(!tile.getPiece().getDirection().equals(direction)){
                            tile.highLight(TARGET_TILE_COLOR);
                        }
                    }
                    else {
                        tile.highLight(TARGET_TILE_COLOR);
                    }
                }

            }
        }
    }
}
