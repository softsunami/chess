package ru.kislyakow.Pieces;

import ru.kislyakow.*;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends LongRangePiece {
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();

        for (int i = -7; i < 8; i++) {
            coordinatesShifts.add(new CoordinatesShift(i, i));
            coordinatesShifts.add(new CoordinatesShift(-i, i));
        }

        return coordinatesShifts;
    }
}
