package sample.background.config;

import javafx.scene.paint.Color;

import static sample.background.config.Param.PIECE_WHITE_COLOR;

public enum PiecePath {
    KING("ChessPiece/White_King.png", "ChessPiece/Black_King.png"),
    QUEEN("ChessPiece/White_Queen.png","ChessPiece/Black_Queen.png"),
    BISHOP("ChessPiece/White_Bishop.png", "ChessPiece/Black_Bishop.png"),
    KNIGHT("ChessPiece/White_Knight.png", "ChessPiece/Black_Knight.png"),
    ROOK("ChessPiece/White_Rook.png","ChessPiece/Black_Rook.png"),
    PAWN("ChessPiece/White_Pawn.png","ChessPiece/Black_Pawn.png");

    private String whitePath;
    private String blackPath;

    PiecePath(String whitePath, String blackPath) {

        this.whitePath = whitePath;
        this.blackPath = blackPath;
    }

    public String getPath(String color){
        if(color.equals(PIECE_WHITE_COLOR)){
            return whitePath;
        }
        return blackPath;
    }
}
