package ru.kislyakow.Coordinates;

import java.util.Objects;

public class Coordinates {
//    rank - x, file - y
    public int rank, file;

    @Override
    public String toString() {
        return "Coordinates{" +
                "rank=" + rank +
                ", file=" + file +
                '}';
    }

    public Coordinates(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(rank + shift.rankShift, file + shift.fileShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int shiftRank = rank + shift.rankShift;
        int shiftFile = file + shift.fileShift;

        if (shiftRank < 1 || shiftRank > 8) return false;
        if (shiftFile < 1 || shiftFile > 8) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return rank == that.rank && file == that.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }
}
