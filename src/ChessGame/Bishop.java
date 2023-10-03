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

        // Move diagonally up and to the right
        for (int i = x + 1, j = y - 1; i <= 8 && j >= 1; i++, j--) {
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

        // Move diagonally down and to the left
        for (int i = x - 1, j = y + 1; i >= 1 && j <= 8; i--, j++) {
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

        // Move diagonally down and to the right
        for (int i = x + 1, j = y + 1; i <= 8 && j <= 8; i++, j++) {
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

        return validMoves;
    }



    public static void BishopMove(Board board, int startX, int startY, int targetX, int targetY) {
        Spot currentSpot = board.getSpot(startX, startY);
        Spot targetSpot = board.getSpot(targetX, targetY);

        List<Spot> validMoves = validBishopMoves(board, currentSpot);

        if (validMoves.contains(targetSpot)) {
            // Check if the target spot is in the list of valid moves
            Piece pieceToMove = currentSpot.getPiece();

            // Move the piece to the target spot
            targetSpot.occupySpot(pieceToMove);
            currentSpot.vacateSpot();

            // Update the piece's position after the move
           // pieceToMove.setPosition(targetSpot);

            // Print a message or perform any other necessary actions
            System.out.println("Valid move! Bishop moved from " +"("+ currentSpot.getX() + "," +currentSpot.getX()+ ")"+" to " +"("+ targetSpot.getX() + "," +targetSpot.getY()+ ")");
        } else {
            System.out.println("Invalid move! Bishop cannot move to " +"("+ targetSpot.getX() + "," +targetSpot.getY()+")");
        }
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
