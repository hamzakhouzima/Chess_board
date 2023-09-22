package ChessGame;
import java.util.List;
import java.util.ArrayList;

public class Rook extends Piece{

    private Color color;
    public Rook(Color color){
        super(color);
        this.color = color;
    }



    public static List<Spot> validRookMoves(Spot currentSpot, Board board) {
        List<Spot> validMoves = new ArrayList<>();

        int x = currentSpot.getX();
        int y = currentSpot.getY();

        // Move horizontally
        for (int i = x + 1; i <= 8; i++) {
            Spot spot = board.getSpot(i, y);
            if (spot == null) break; // Out of bounds
            if (spot.isEmpty()) {
                validMoves.add(spot);
            } else if (!spot.isEmpty()) {
                if (spot.getPiece().getColor() != currentSpot.getPiece().getColor()) {
                    validMoves.add(spot);
                }
                break; // Can't move through pieces
            }
        }

        // Move vertically
        for (int j = y + 1; j <= 8; j++) {
            Spot spot = board.getSpot(x, j);
            if (spot == null) break; // Out of bounds
            if (spot.isEmpty()) {
                validMoves.add(spot);
            } else if (!spot.isEmpty()) {
                if (spot.getPiece().getColor() != currentSpot.getPiece().getColor()) {
                    validMoves.add(spot);
                }
                break; // Can't move through pieces
            }
        }

        // Repeat for other directions

        return validMoves;
    }

    @Override
    public void Move(Board board, Spot currentSpot, Spot targetSpot) {
        // Check if the move is valid (based on the piece's validMoves method)
        List<Spot> validMoves = validRookMoves(currentSpot,board);
        if (!validMoves.contains(targetSpot)) {
            System.out.println("Invalid move. Please choose a valid move.");
            return;
        }

        // Capture the piece (if any) at the target spot
        Piece capturedPiece = targetSpot.getPiece();

        // Move the piece to the target spot
        targetSpot.occupySpot(this);

        // Clear the previous spot
        currentSpot.vacateSpot();

        // Update the piece's position
        setPosition(targetSpot);

        // Print the move result
        System.out.println("Moved to " + targetSpot.getX() + "," + targetSpot.getY());

        // Handle capture (if any)
        if (capturedPiece != null) {
            System.out.println("Captured a " + capturedPiece.getColor() + " " + capturedPiece.getClass().getSimpleName());
        }

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
