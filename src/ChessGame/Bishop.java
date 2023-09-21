package ChessGame;
import java.util.List;
import java.util.ArrayList;
public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);

    }
    public static List<Spot> validBishopMoves(Board board, Spot currentSpot) {
        List<Spot> validMoves = new ArrayList<>();
        int x = currentSpot.getX();
        int y = currentSpot.getY();

        // Move diagonally up and to the left
        for (int i = x - 1, j = y - 1; i >= 1 && j >= 1; i--, j--) {
            Spot spot = board.getSpot(i, j);
            if (spot.isEmpty()) {
                validMoves.add(spot);
            } else if (spot.getPiece().getColor() != currentSpot.getPiece().getColor()) {
                validMoves.add(spot);
                break;
            } else {
                break;
            }
        }

        // Repeat for other diagonal directions

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
