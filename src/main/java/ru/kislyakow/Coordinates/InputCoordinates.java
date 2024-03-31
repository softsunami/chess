package ru.kislyakow.Coordinates;

import ru.kislyakow.Board.Board;
import ru.kislyakow.Pieces.Color;
import ru.kislyakow.Pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    public static Coordinates inputCoordinatesForColor(Color color, Board board) {
        while (true) {
            Coordinates coordinates = input();

            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square, try again");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if (piece.color != color)  {
                System.out.println("Wrong color, try again");
                continue;
            }

            if (piece.getAvailableMoveSquares(board).isEmpty()) {
                System.out.println("This piece don't have available moves, try again");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableCoordinates(Set<Coordinates> coordinates) {
        System.out.println("Enter square to move: ");
        while (true) {
            Coordinates input = input();

            if (!coordinates.contains(input)) {
                System.out.println("Unavailable square to move, try again");
                continue;
            }

            return input;
        }
    }


    private static Coordinates input() {
        Scanner scanner = new Scanner(System.in);
        char rankChar, fileChar;
        while(true) {
            System.out.println("Enter coordinates (ex A1): ");
            String line = scanner.nextLine().toUpperCase();

            if (line.length() != 2) {
                System.out.println("Invalid format, try again");
                continue;
            }

            rankChar = line.charAt(0);
            fileChar = line.charAt(1);

            if ((rankChar >= 'A' && rankChar <= 'H') && (fileChar >= '1' && fileChar <= '8')) {
                return new Coordinates(rankChar - 'A' + 1, fileChar - '1' + 1);
            }
        }
    }

}
