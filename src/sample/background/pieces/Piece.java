package sample.background.pieces;

import javafx.scene.image.ImageView;
import sample.background.Board;
import sample.background.Tile;
import sample.background.config.Direction;


import static sample.background.config.Param.TILE_SIZE;

public abstract class Piece extends ImageView {

   protected String name;
   protected Direction direction;
   protected int x;
   protected int y;
   protected boolean firstMove = true;

   public Piece(){}
  public Piece(int x, int y){
     fitHeightProperty();
     fitWidthProperty();
     setPreserveRatio(true);
     setSmooth(true);
     setCache(true);
     setPosition(x,y);
     resize();
  }


    public Direction getDirection() {
        return direction;
    }

    public String getName(){
     return name;
   }



   public void resize(){
      //only need to resize width or height because preserve ratio is true
      setFitWidth(0.8 * TILE_SIZE);
   }

   public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
      setX(x * TILE_SIZE);
      setY(y * TILE_SIZE);
   }

   public void translate(double x, double y){
      setTranslateX(x);
      setTranslateY(y);
   }
   public  void move(Tile source, Tile target, Board board){

       if(target.hasPiece()){
           board.getChildren().remove(target.getPiece());
       }
       firstMove = false;
       Piece piece = source.getPiece();
       source.setPiece(null);
       target.setPiece(piece);
   }



    public void highlightPossibleTarget(Board board) {

    }

    public boolean validRange(int pos){
        if(pos>=0 && pos < 8){
            return true;
        }
        return false;
    }

    public boolean validRange(int x, int y){
        if((x>=0 && x < 8) && (y>=0 && y<8)){
            return true;
        }
        return false;
    }

    public boolean isFirstMove(){
       return firstMove;
    }


}
