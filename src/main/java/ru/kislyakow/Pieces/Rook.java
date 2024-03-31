package ru.kislyakow.Pieces;

import ru.kislyakow.Coordinates.Coordinates;
import ru.kislyakow.Coordinates.CoordinatesShift;

import java.util.Set;

public class Rook extends LongRangePiece implements IRook {
    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getRookMoves();
    }
}
