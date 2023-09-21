package ChessGame;
import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);

    }
    public List<Spot> validKnightMoves(Board board, Spot currentSpot) {
        List<Spot> validMoves = new ArrayList<>();
        int x = currentSpot.getX();
        int y = currentSpot.getY();

        // Define possible knight move offsets
        int[][] knightMoves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] move : knightMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            Spot spot = board.getSpot(newX, newY);

            if (spot != null && (spot.isEmpty() || spot.getPiece().getColor() != currentSpot.getPiece().getColor())) {
                validMoves.add(spot);
            }
        }

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
