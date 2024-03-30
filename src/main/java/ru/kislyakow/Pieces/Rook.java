package ru.kislyakow.Pieces;

import ru.kislyakow.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends Piece{
    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(0, i));
            result.add(new CoordinatesShift(i, 0));
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableToMove(coordinates, board);
        if (!result) return false;

        List<Coordinates> verticalCoordinates = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        List<Coordinates> horizontalCoordinates = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);


        for (Coordinates coordinates1 : verticalCoordinates) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        for (Coordinates coordinates1 : horizontalCoordinates) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        return true;
    }
}
