package ru.kislyakow.Pieces;

import ru.kislyakow.Board;
import ru.kislyakow.Color;
import ru.kislyakow.Coordinates;
import ru.kislyakow.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                coordinatesShifts.add(new CoordinatesShift(i, j));
            }
        }

        return coordinatesShifts;
    }

    @Override
    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        if (!super.isSquareAvailableToMove(coordinates, board)) return false;

        if (board.isSquareAttackedByColor(coordinates, color.opposite())) return false;

        return true;
    }
}
