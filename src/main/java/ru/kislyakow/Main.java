package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.fromFen("8/p2p2b1/8/8/1p1Q3p/2q5/5n2/3p4");
        Game game = new Game(board);
        game.gameLoop();


//        48 min prt2
    }
}