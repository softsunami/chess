package ru.kislyakow;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.setupDefaultPosition();
        Game game = new Game(board);
        game.gameLoop();
    }
}