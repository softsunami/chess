package ru.kislyakow.Pieces;

import ru.kislyakow.Board;
import ru.kislyakow.BoardUtils;
import ru.kislyakow.Color;
import ru.kislyakow.Coordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class LongRangePiece extends Piece {

    public LongRangePiece(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        if (!super.isSquareAvailableToMove(coordinates, board)) return false;

        boolean result = true;
        List<Coordinates> coordinatesList = new ArrayList<>();
        if (this.coordinates.file == coordinates.file) {
            coordinatesList = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
        } else if (this.coordinates.rank == coordinates.rank) {
            coordinatesList = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        } else {
            coordinatesList = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
        }

        for (Coordinates coordinates1 : coordinatesList) {
            if (!board.isSquareEmpty(coordinates1)) return false;
        }

        return result;
    }
}
