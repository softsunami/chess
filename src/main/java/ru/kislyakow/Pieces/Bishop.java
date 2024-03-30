package ru.kislyakow.Pieces;

import ru.kislyakow.*;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }
}
