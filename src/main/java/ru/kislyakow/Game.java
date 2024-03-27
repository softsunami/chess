package ru.kislyakow;

import ru.kislyakow.Pieces.Piece;

public class Game {
    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        InputCoordinates inputCoordinates = new InputCoordinates();
        boolean isWhiteMove = true;
        while(true) {
            renderer.render(board);

            System.out.print("[From] ");
            Coordinates coordinatesFrom = inputCoordinates.input();

            System.out.print("[To] ");
            Coordinates coordinatesTo = inputCoordinates.input();

            if (board.isSquareEmpty(coordinatesFrom)) continue;

            Piece piece = board.getPiece(coordinatesFrom);
            if (isWhiteMove && piece.color != Color.WHITE) continue;
            else if (!isWhiteMove && piece.color != Color.BLACK) continue;

            if (piece.getAvailableMoveSquares(board).contains(coordinatesTo)) {
                board.movePiece(coordinatesFrom, coordinatesTo);
                isWhiteMove = !isWhiteMove;
            }
        }
    }
}
