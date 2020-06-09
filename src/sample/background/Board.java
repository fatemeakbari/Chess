package sample.background;

import javafx.scene.layout.Pane;
import sample.background.config.Param;
import sample.background.pieces.*;

import static sample.background.config.Param.*;
import static sample.background.config.Direction.*;

public class Board extends Pane {


    private Tile[][] tiles= new Tile[WIDTH][HEIGHT];

    public Board(String myColor){

        setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        createTiles();
        initPiece(myColor);
    }

    public Tile getTile(int i, int j){
        return tiles[i][j];
    }

    public void setTiles(int i, int j, Tile tile){
        tiles[i][j] = tile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    private void createTiles(){
        boolean light;
        for (int row = 0; row< WIDTH; row++) {
            for (int col=0; col<HEIGHT; col++){
                light = (row + col) % 2 == 0;
                tiles[row][col] = new Tile(light, row, col);
                getChildren().add(tiles[row][col]);
            }
        }
    }

    public void unHighLightAll(){
        for (int row = 0; row< WIDTH; row++) {
            for (int col=0; col<HEIGHT; col++){
                tiles[row][col].unHighLight();
            }
        }
    }
    private void initPiece(String color){

        tiles[0][7].setPiece(new RookPiece(0,7, DOWN, color));
        tiles[1][7].setPiece(new KnightPiece(1,7, DOWN, color));
        tiles[2][7].setPiece(new BishopPiece(2,7, DOWN, color));
        tiles[3][7].setPiece(new KingPiece(3,7, DOWN, color));
        tiles[4][7].setPiece(new QueenPiece(4,7, DOWN, color));
        tiles[5][7].setPiece(new BishopPiece(5,7, DOWN, color));
        tiles[6][7].setPiece(new KnightPiece(6,7, DOWN, color));
        tiles[7][7].setPiece(new RookPiece(7,7, DOWN, color));

        tiles[0][6].setPiece(new PawnPiece(0,6, DOWN, color));
        tiles[1][6].setPiece(new PawnPiece(1,6, DOWN, color));
        tiles[2][6].setPiece(new PawnPiece(2,6, DOWN, color));
        tiles[3][6].setPiece(new PawnPiece(3,6, DOWN, color));
        tiles[4][6].setPiece(new PawnPiece(4,6, DOWN, color));
        tiles[5][6].setPiece(new PawnPiece(5,6, DOWN, color));
        tiles[6][6].setPiece(new PawnPiece(6,6, DOWN, color));
        tiles[7][6].setPiece(new PawnPiece(7,6, DOWN, color));

        if(color.equals(PIECE_WHITE_COLOR)){
            color= PIECE_BLACK_COLOR;
        }
        else {
            color = PIECE_WHITE_COLOR;
        }


        tiles[0][0].setPiece(new RookPiece(0, 0, TOP, color));
        tiles[1][0].setPiece(new KnightPiece(1, 0, TOP, color));
        tiles[2][0].setPiece(new BishopPiece(2, 0, TOP, color));
        tiles[3][0].setPiece(new KingPiece( 3,0, TOP, color));
        tiles[4][0].setPiece(new QueenPiece(4, 0, TOP, color));
        tiles[5][0].setPiece(new BishopPiece(5, 0, TOP, color));
        tiles[6][0].setPiece(new KnightPiece(6, 0, TOP, color));
        tiles[7][0].setPiece(new RookPiece(7, 0, TOP, color));

        tiles[0][1].setPiece(new PawnPiece(0,1, TOP, color));
        tiles[1][1].setPiece(new PawnPiece(1,1, TOP, color));
        tiles[2][1].setPiece(new PawnPiece(2,1, TOP, color));
        tiles[3][1].setPiece(new PawnPiece(3,1, TOP, color));
        tiles[4][1].setPiece(new PawnPiece(4,1, TOP, color));
        tiles[5][1].setPiece(new PawnPiece(5,1, TOP, color));
        tiles[6][1].setPiece(new PawnPiece(6,1, TOP, color));
        tiles[7][1].setPiece(new PawnPiece(7,1, TOP, color));


        for(int i=0;i<8;i++){
            getChildren().addAll(
                    tiles[i][0].getPiece(),
                    tiles[i][1].getPiece(),
                    tiles[i][6].getPiece(),
                    tiles[i][7].getPiece());
        }
    }

}
