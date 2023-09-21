package ChessGame;

import java.util.List;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }
    public List<Spot> validMoves(Board board, Spot currentSpot) {
        List<Spot> validMoves = new ArrayList<>();
        int x = currentSpot.getX();
        int y = currentSpot.getY();

        // Add valid moves for a rook (horizontally and vertically)
        validMoves.addAll(Rook.validRookMoves( currentSpot,board));

        // Add valid moves for a bishop (diagonally)
        validMoves.addAll(Bishop.validBishopMoves(board, currentSpot));

        return validMoves;
    }

    @Override
    public void Move(Board board, Spot currentSpot, Spot targetSpot) {

    }

    @Override
    public void Take() {

    }

    @Override
    public void Check() {

    }

    @Override
    public void isValidMove() {

    }
}
