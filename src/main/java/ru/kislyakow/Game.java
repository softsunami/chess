package ru.kislyakow;

import ru.kislyakow.Board.Board;
import ru.kislyakow.Board.BoardConsoleRenderer;
import ru.kislyakow.Coordinates.Coordinates;
import ru.kislyakow.Coordinates.InputCoordinates;
import ru.kislyakow.Pieces.Color;
import ru.kislyakow.Pieces.Piece;

public class Game {
    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteMove = true;
        while(true) {
            renderer.render(board);

            System.out.print("[From] ");
            Coordinates coordinatesFrom = InputCoordinates.inputCoordinatesForColor(isWhiteMove ? Color.WHITE : Color.BLACK, board);
            Piece piece = board.getPiece(coordinatesFrom);

            renderer.render(board, piece);

            System.out.print("[To] ");
            Coordinates coordinatesTo = InputCoordinates.inputAvailableCoordinates(piece.getAvailableMoveSquares(board));

            board.movePiece(coordinatesFrom, coordinatesTo);

            isWhiteMove = !isWhiteMove;
        }
    }
}
