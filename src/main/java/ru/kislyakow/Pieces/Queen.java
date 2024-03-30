package ru.kislyakow.Pieces;

import ru.kislyakow.*;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    public Queen(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();

        for (int i = -7; i < 8; i++) {
            coordinatesShifts.add(new CoordinatesShift(i, i));
            coordinatesShifts.add(new CoordinatesShift(-i, i));

            if (i == 0) continue;
            coordinatesShifts.add(new CoordinatesShift(0, i));
            coordinatesShifts.add(new CoordinatesShift(i, 0));
        }

        return coordinatesShifts;
    }

    @Override
    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        if (!super.isSquareAvailableToMove(coordinates, board)) return false;

        boolean result = true;

        for (Coordinates coordinates1 : BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates)) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        for (Coordinates coordinates1 : BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates)) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        for (Coordinates coordinates1 : BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates)) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        return result;
    }
}
