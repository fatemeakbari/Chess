package sample.background;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import sample.background.pieces.Piece;

import static sample.background.config.Param.*;

public class Tile extends Rectangle {


    private Piece piece = null;
    private boolean isHighLight = false;
    private Color hColor;


    public Tile(boolean light, int x, int y){

        super(x,y,TILE_SIZE,TILE_SIZE);
        relocate(x*TILE_SIZE, y* TILE_SIZE);
        setFill(light? BOARD_LIGHT_COLOR : BOARD_DARK_COLOR);
    }


    public boolean hasPiece(){
        return piece != null;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
        if(piece !=null){

            this.piece.setPosition((int)getX(),(int)getY());
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public void highLight(Color color){
        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(4);
        setStroke(color);
        isHighLight = true;
        hColor = color;
    }

    public void unHighLight(){
        setStroke(null);
        isHighLight = false;
    }

    public boolean isHighLight(){
        return isHighLight;
    }

    public boolean isTargetColor(){
        return hColor.equals(TARGET_TILE_COLOR);
    }

}
