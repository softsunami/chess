package ru.kislyakow.Pieces;

import ru.kislyakow.Color;
import ru.kislyakow.Coordinates;
import ru.kislyakow.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{
    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        int[] offsets = new int[]{1, -1, 2, -2};

        for (int i : offsets) {
            for (int j: offsets) {
                if (i != j && -i != j) {
                    result.add(new CoordinatesShift(i, j));
                }
            }
        }

        return result;
    }
}
