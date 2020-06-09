package sample.background;

import sample.background.config.Direction;

import static sample.background.config.Param.SOURCE_TILE_COLOR;
import static sample.background.config.Param.TILE_SIZE;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Direction activeDir;
    private boolean firstStep = false;
    private boolean secondStep = false;
    private Tile sourceTile = null;

    public Game(Board board, Player player1, Player player2){
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        activeDir = player1.getDirection();
    }

    public void selectPiece(double x, double y) {
        int oldX = (int) (x / TILE_SIZE);
        int oldY = (int) (y / TILE_SIZE);

        Tile tile = board.getTile(oldX,oldY);

        if(tile.hasPiece() && tile.getPiece().getDirection().equals(activeDir)){
            board.unHighLightAll();
            tile.highLight(SOURCE_TILE_COLOR);
            tile.getPiece().highlightPossibleTarget(board);
            sourceTile = tile;
        }
        else if(tile.isHighLight() && tile.isTargetColor()){

            if(tile.hasPiece()){
                board.getChildren().remove(tile.getPiece());
            }
            sourceTile.getPiece().move(sourceTile,tile);
            board.unHighLightAll();


            if(activeDir.equals(player1.getDirection())){
                activeDir = player2.getDirection();
            }
            else {
                activeDir = player1.getDirection();
            }

        }

    }
}
