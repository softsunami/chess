package ru.kislyakow;

import ru.kislyakow.Pieces.*;

public class BoardFactory {

    public static Board fromFen(String fen) {
        Board board = new Board();
        String[] fens = fen.split("/");

        int rank = 1, file = 8;
        for (String line : fens) {
            for (char alias : line.toCharArray()) {
                if (Character.isDigit(alias)) {
                    rank = rank + Integer.parseInt(String.valueOf(alias));
                } else {
                    Piece piece = getPieceFromAlias(alias, new Coordinates(rank, file));
                    if (piece != null) board.setPiece(piece.coordinates, piece);
                    rank++;
                }
            }
            rank = 1;
            file--;
        }

        return board;
    }

    public static Board setupDefaultPosition() {
        return fromFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    private static Piece getPieceFromAlias(char alias, Coordinates coordinates) {
        Color color;

        if (Character.isUpperCase(alias)) color = Color.WHITE;
        else color = Color.BLACK;

        switch (Character.toLowerCase(alias)) {
            case 'r':
                return new Rook(coordinates, color);

            case 'n':
                return new Knight(coordinates, color);

            case 'b':
                return new Bishop(coordinates, color);

            case 'q':
                return new Queen(coordinates, color);

            case 'k':
                return new King(coordinates, color);

            case 'p':
                return new Pawn(coordinates, color);

            default:
                return null;
        }
    }

}
