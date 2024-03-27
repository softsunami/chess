package ru.kislyakow;

import java.util.Scanner;

public class InputCoordinates {

    private final Scanner scanner = new Scanner(System.in);

    public Coordinates input() {
        char rankChar, fileChar;
        while(true) {
            System.out.println("Enter coordinates (ex A1): ");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid format");
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
