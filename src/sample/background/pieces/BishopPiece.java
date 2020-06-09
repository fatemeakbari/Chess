package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class BishopPiece extends Piece{

    public BishopPiece(int x, int y,Direction dir){
        super(x,y);
        direction = dir;
    }
    public BishopPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Bishop_"+color;
        direction = dir;
        String imgPath = PiecePath.BISHOP.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    private boolean isCastle(Tile tile){

        if(tile.hasPiece()){
            if(!tile.getPiece().getDirection().equals(direction)){
                tile.highLight(TARGET_TILE_COLOR);
            }
            return false;
        }
        tile.highLight(TARGET_TILE_COLOR);
        return true;
    }

    @Override
    public void highlightPossibleTarget(Board board){

        int row, col;
        int offset=1;

        //line y = x
        for(int i=0;i<2;i++)
        {
            row = x+offset;
            col = y+offset;

            while (validRange(row, col)){
                if(!isCastle(board.getTiles()[row][col])){
                    break;
                }
                row+=offset;
                col+=offset;
            }
            offset = -1*offset;
        }

        offset = 1;
        //line y = -x
        for(int i=0;i<2;i++)
        {
            row = x+offset;
            col = y-offset;

            while (validRange(row, col)){
                if(!isCastle(board.getTiles()[row][col])){
                    break;
                }
                row+=offset;
                col-=offset;
            }

            offset = -1*offset;
        }

    }
}
