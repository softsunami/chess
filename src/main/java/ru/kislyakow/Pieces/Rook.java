package ru.kislyakow.Pieces;

import ru.kislyakow.Color;
import ru.kislyakow.Coordinates;
import ru.kislyakow.CoordinatesShift;

import java.util.Set;

public class Rook extends Piece{
    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
