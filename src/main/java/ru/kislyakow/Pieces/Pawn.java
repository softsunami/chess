package ru.kislyakow.Pieces;

import ru.kislyakow.Board.Board;
import ru.kislyakow.Board.BoardUtils;
import ru.kislyakow.Coordinates.Coordinates;
import ru.kislyakow.Coordinates.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece{
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();


        if (color == Color.WHITE) {
            if (coordinates.file == 2) result.add(new CoordinatesShift(0, 2));
            result.add(new CoordinatesShift(0, 1));
            result.add(new CoordinatesShift(1, 1));
            result.add(new CoordinatesShift(-1, 1));
        } else {
            if (coordinates.file == 7) result.add(new CoordinatesShift(0, -2));
            result.add(new CoordinatesShift(0, -1));
            result.add(new CoordinatesShift(1, -1));
            result.add(new CoordinatesShift(-1, -1));
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        if (!super.isSquareAvailableToMove(coordinates, board)) return false;

        if (coordinates.rank == this.coordinates.rank) {
            if (BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates).isEmpty()) {
                return board.isSquareEmpty(coordinates);
            } else return false;
        } else {
            return !board.isSquareEmpty(coordinates);
        }
    }
}
