package ru.kislyakow;

import ru.kislyakow.Pieces.*;

public class BoardSetupUtil {
    public static void setupDefaultPawns(Board board) {
        for (int rank = 1; rank <= 8; rank++) {
            board.setPiece(new Coordinates(rank, 2), new Pawn(new Coordinates(rank, 2), Color.WHITE));
            board.setPiece(new Coordinates(rank, 7), new Pawn(new Coordinates(rank, 7), Color.BLACK));
        }
    }

    public static void setupDefaultKings(Board board) {
        board.setPiece(new Coordinates(5, 1), new King(new Coordinates(5, 1), Color.WHITE));
        board.setPiece(new Coordinates(5, 8), new King(new Coordinates(5, 8), Color.BLACK));
    }

    public static void setupDefaultQueens(Board board) {
        board.setPiece(new Coordinates(4, 1), new Queen(new Coordinates(4, 1), Color.WHITE));
        board.setPiece(new Coordinates(4, 8), new Queen(new Coordinates(4, 8), Color.BLACK));
    }

    public static void setupDefaultRook(Board board) {
        board.setPiece(new Coordinates(1, 1), new Rook(new Coordinates(1, 1), Color.WHITE));
        board.setPiece(new Coordinates(8, 1), new Rook(new Coordinates(8, 1), Color.WHITE));
        board.setPiece(new Coordinates(1, 8), new Rook(new Coordinates(1, 8), Color.BLACK));
        board.setPiece(new Coordinates(8, 8), new Rook(new Coordinates(8, 8), Color.BLACK));
    }

    public static void setupDefaultKnights(Board board) {
        board.setPiece(new Coordinates(2, 1), new Knight(new Coordinates(2, 1), Color.WHITE));
        board.setPiece(new Coordinates(7, 1), new Knight(new Coordinates(7, 1), Color.WHITE));
        board.setPiece(new Coordinates(2, 8), new Knight(new Coordinates(2, 8), Color.BLACK));
        board.setPiece(new Coordinates(7, 8), new Knight(new Coordinates(7, 8), Color.BLACK));
    }

    public static void setDefaultBishop(Board board) {
        board.setPiece(new Coordinates(3, 1), new Bishop(new Coordinates(3, 1), Color.WHITE));
        board.setPiece(new Coordinates(6, 1), new Bishop(new Coordinates(6, 8), Color.WHITE));
        board.setPiece(new Coordinates(3, 8), new Bishop(new Coordinates(3, 8), Color.BLACK));
        board.setPiece(new Coordinates(6, 8), new Bishop(new Coordinates(6, 8), Color.BLACK));
    }

}
