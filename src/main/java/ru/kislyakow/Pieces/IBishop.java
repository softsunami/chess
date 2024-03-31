package ru.kislyakow.Pieces;

import ru.kislyakow.Coordinates.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {

    default Set<CoordinatesShift> getBishopMoves() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();

        for (int i = -7; i < 8; i++) {
            coordinatesShifts.add(new CoordinatesShift(i, i));
            coordinatesShifts.add(new CoordinatesShift(-i, i));
        }

        return coordinatesShifts;
    }
}
