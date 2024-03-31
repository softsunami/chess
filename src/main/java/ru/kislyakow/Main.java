package ru.kislyakow;

import ru.kislyakow.Board.Board;
import ru.kislyakow.Board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = BoardFactory.setupDefaultPosition();
        Game game = new Game(board);
        game.gameLoop();
    }
}