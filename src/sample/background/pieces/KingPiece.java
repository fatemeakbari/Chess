package sample.background.pieces;

import javafx.scene.image.Image;
import sample.background.config.Direction;
import sample.background.config.PiecePath;

public class KingPiece extends Piece {

    public KingPiece(int x, int y, Direction dir, String color){
        super(x,y);
        name = "King_"+color;
        String imgPath = PiecePath.KING.getPath(color);
        Image image = new Image(imgPath);
        setImage(image);
    }

    public void move(){

    }

//    @Override
//    public List getPossibleDestination() {
//
//        List destination = new ArrayList();
//        for(int row=x-1;row<x+1;row++)
//            for(int col=y-1;col<y+1;col++){
//                if((row>=0 && row<8) && (col>=0 && col<8) && (row!=x && col!=y) ){
//                    destination.add(Arrays.asList(row,col));
//                }
//            }
//        return destination;
//    }


}
