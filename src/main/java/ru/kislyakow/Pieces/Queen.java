package ru.kislyakow.Pieces;

import ru.kislyakow.Coordinates.Coordinates;
import ru.kislyakow.Coordinates.CoordinatesShift;

import java.util.Set;

public class Queen extends LongRangePiece implements IRook, IBishop {
    public Queen(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRookMoves());
        return moves;
    }
}
