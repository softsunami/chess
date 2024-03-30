package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.fromFen("8/3b4/8/8/1p1R3p/8/3n4/8");
        Game game = new Game(board);
        game.gameLoop();

//        48 min prt2
    }
}