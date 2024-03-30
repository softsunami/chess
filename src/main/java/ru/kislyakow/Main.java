package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.fromFen("8/p5b1/8/8/3Q3p/2q5/5n2/8");
        Game game = new Game(board);
        game.gameLoop();


//        48 min prt2
    }
}