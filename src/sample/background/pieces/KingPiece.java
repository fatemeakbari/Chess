package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

import static sample.background.config.Param.TARGET_TILE_COLOR;

public class KingPiece extends Piece {

    private boolean canCastling = false;

    public KingPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "King_"+color;
        direction = dir;
        String imgPath = PiecePath.KING.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }


    @Override
    public void move(Tile source, Tile target, Board board) {

//        System.out.println("hyyy");
//        System.out.println("cancastling "+canCastling);
//        System.out.println("result = "+target.getPiece().getClass().equals(RookPiece.class));
//        System.out.println("class = "+RookPiece.class);
//        System.out.println("class target = "+target.getPiece().getClass());

        if(canCastling && target.getPiece().getClass().equals(RookPiece.class)){

            int currentX = x;
            if( target.getX() > x){ //right side

                board.getTile(currentX+2, y).setPiece(source.getPiece());
                board.getTile(currentX+1, y).setPiece(target.getPiece());
                source.setPiece(null);
                target.setPiece(null);
            }

            if( target.getX() < x){ //left side

                board.getTile(currentX-2, y).setPiece(source.getPiece());
                board.getTile(currentX-1, y).setPiece(target.getPiece());
                source.setPiece(null);
                target.setPiece(null);
            }

            canCastling = false;
            firstMove = false;

        }
        else {
            super.move(source,target,board);
        }
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

        Tile right = null;
        Tile left = null;
        if(direction.equals(Direction.DOWN)){
            right = board.getTile(7,7);
            left = board.getTile(0,7);
        }
        else {
            right = board.getTile(7,0);
            left = board.getTile(0,0);
        }

        if(isFirstMove()
                && right.getPiece().isFirstMove()
                && !board.getTile(x+1, y).hasPiece()
                && !board.getTile(x+2,y).hasPiece()
        ){
            right.highLight(TARGET_TILE_COLOR);
            canCastling = true;
        }

        if(isFirstMove()
                && left.getPiece().isFirstMove()
                && !board.getTile(x-1, y).hasPiece()
                && !board.getTile(x-2,y).hasPiece()
                && !board.getTile(x-3,y).hasPiece()
        ){
            left.highLight(TARGET_TILE_COLOR);
            canCastling = true;
        }
    }
}
