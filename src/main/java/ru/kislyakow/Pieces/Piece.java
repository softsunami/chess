package ru.kislyakow.Pieces;

import ru.kislyakow.Board.Board;
import ru.kislyakow.Coordinates.Coordinates;
import ru.kislyakow.Coordinates.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public Coordinates coordinates;
    public final Color color;

    public Piece(Coordinates coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    public Set<Coordinates> getAvailableMoveSquares(Board board) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : getPieceMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableToMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }
            }
        }

        return result;
    }

    protected boolean isSquareAvailableToMove(Coordinates coordinates, Board board) {
        if (board.isSquareEmpty(coordinates)) return true;
        if (board.getPiece(coordinates).color != color) return true;
        return false;
    }

    protected abstract Set<CoordinatesShift> getPieceMoves();
}
