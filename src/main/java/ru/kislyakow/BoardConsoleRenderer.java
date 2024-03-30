package ru.kislyakow;

import ru.kislyakow.Pieces.Pawn;
import ru.kislyakow.Pieces.Piece;

import java.util.Collections;
import java.util.Set;

public class BoardConsoleRenderer {
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void render(Board board, Piece pieceToMove) {
        Set<Coordinates> availableMoves = Collections.emptySet();
        if (pieceToMove != null) {
            availableMoves = pieceToMove.getAvailableMoveSquares(board);
        }

        for (int file = 8; file >= 0; file--) {
            if (file == 0) {
                System.out.println(" A  B  C  D  E  F  G  H ");
                continue;
            }
            for (int rank = 1; rank <= 8 ; rank++) {
                Coordinates coordinates = new Coordinates(rank, file);
                boolean isHighlight = availableMoves.contains(coordinates);

                if (board.isSquareEmpty(coordinates)) {
                    System.out.print(getSpriteForEmptySquare(new Coordinates(rank, file), isHighlight));
                } else {
                    System.out.print(getPieceSprite(board.getPiece(coordinates), isHighlight));
                }

            }
            System.out.println(ANSI_RESET + " " +  file);
        }
    }

    public void render(Board board) {
        render(board, null);
    }

    private String getPieceSprite(Piece piece, boolean isHighlight) {
        return colorizeSprite(selectUnicodeSpriteForPiece(piece), piece.color, Board.isSquareDark(piece.coordinates), isHighlight);
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return " ♟︎ ";

            case "Knight":
                return " ♞ ";

            case "Bishop":
                return " ♝ ";

            case "Rook":
                return " ♜ ";

            case "Queen":
                return " ♛ ";

            case "King":
                return " ♚ ";
        }

        return "   ";
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight) {
        return colorizeSprite("   ", Color.BLACK, Board.isSquareDark(coordinates), isHighlight);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighlighted) {
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighlighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }
}
