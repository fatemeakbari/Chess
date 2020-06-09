package sample.background.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class RookPiece extends Piece {

    public RookPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "Rook_"+color;
        direction = dir;
        String imgPath = PiecePath.ROOK.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    public boolean isCastle(Tile tile){

        if(tile.hasPiece()){
            System.out.println("name "+tile.getPiece().getName()+ " dire "+tile.getPiece().getDirection());
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
        System.out.println(name);
        Color hColor = Color.YELLOW;

        for(int row=x+1;row<8;row++){
            if(!isCastle(board.getTiles()[row][y])){
                break;
            }
        }
        
        for(int row=x-1;row>=0;row--){
            System.out.println("row "+row+" y "+y);
            if(!isCastle(board.getTiles()[row][y])){
                break;
            }
        }

        for(int col=y+1;col<8;col++){
            if(!isCastle(board.getTiles()[x][col])){
                break;
            }
        }

        for(int col=y-1;col>=0;col--){
            if(!isCastle(board.getTiles()[x][col])){
                break;
            }
        }


    }


}
