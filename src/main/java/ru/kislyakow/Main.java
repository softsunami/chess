package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.fromFen("8/p2p2b1/3P1P2/8/1pP2Pp/8/qP3Pn1/3p4");
        Game game = new Game(board);
        game.gameLoop();


//        48 min prt2
    }
}