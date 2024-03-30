package ru.kislyakow.Pieces;

import ru.kislyakow.*;

import java.util.HashSet;
import java.util.List;
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
