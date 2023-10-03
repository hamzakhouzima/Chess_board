package ChessGame;
import java.util.List;
import java.util.ArrayList;
public class King extends Piece {


    public King(Color color) {
        super(color);

    }
    public static List<Spot> validKingMoves(Board board, Spot currentSpot) {
        List<Spot> validMoves = new ArrayList<>();
        int x = currentSpot.getX();
        int y = currentSpot.getY();
        Color color = currentSpot.getPiece().getColor();

        // Define possible king move offsets
        int[][] kingMoves = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] move : kingMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            Spot spot = board.getSpot(newX, newY);

            if (spot != null && (spot.isEmpty() || spot.getPiece().getColor() != color)) {
                validMoves.add(spot);
            }
        }

        // Check for castling moves (if applicable)
        // Add castling moves here if conditions are met

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
