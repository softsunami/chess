package ru.kislyakow.Pieces;

import ru.kislyakow.Color;
import ru.kislyakow.Coordinates;
import ru.kislyakow.CoordinatesShift;

import java.util.Set;

public class Queen extends Piece{
    public Queen(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}