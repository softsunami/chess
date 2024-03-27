package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPosition();
//        Game game = new Game(board);
//        game.gameLoop();

        BoardFactory factory = new BoardFactory();
        Board board = factory.fromFen("r1bqkbKr/pppppppp/n4n2/3Q4/5B2/P7/1PPPPPPP/RN3BNR");

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        renderer.render(board);
    }
}
