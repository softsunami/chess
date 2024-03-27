package ru.kislyakow;

import ru.kislyakow.Pieces.*;

import java.util.HashMap;

public class Board {
    private HashMap<Coordinates, Piece> piecesMap = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        piecesMap.put(coordinates, piece);
    }

    public void removePiece(Coordinates coordinates) {
        piecesMap.remove(coordinates);
    }

    public void movePiece(Coordinates coordinatesFrom, Coordinates coordinatesTo) {
        Piece piece = getPiece(coordinatesFrom);
        removePiece(coordinatesFrom);
        setPiece(coordinatesTo, piece);
    }

    public void setupDefaultPiecesPosition() {
        BoardSetupUtil.setupDefaultPawns(this);
        BoardSetupUtil.setupDefaultRook(this);
        BoardSetupUtil.setDefaultBishop(this);
        BoardSetupUtil.setupDefaultKnights(this);
        BoardSetupUtil.setupDefaultKings(this);
        BoardSetupUtil.setupDefaultQueens(this);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !piecesMap.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates) {
        return piecesMap.get(coordinates);
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (coordinates.file + coordinates.rank) % 2 == 0;
    }
}
