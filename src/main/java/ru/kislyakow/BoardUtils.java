package ru.kislyakow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardUtils {

    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates source, Coordinates to) {
        List<Coordinates> result = new ArrayList<>();
        if (source.rank != to.rank) return Collections.emptyList();

        int shift = source.file > to.file ? -1 : 1;

        for (int i = source.file + shift; i != to.file; i += shift) {
            result.add(new Coordinates(source.rank, i));
        }

        return result;
    }


    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates source, Coordinates to) {
        List<Coordinates> result = new ArrayList<>();
        if (source.file!= to.file) return Collections.emptyList();

        int shift = source.rank > to.rank ? -1 : 1;

        for (int i = source.rank + shift; i != to.rank; i += shift) {
            result.add(new Coordinates(i, source.file));
        }

        return result;
    }
}
