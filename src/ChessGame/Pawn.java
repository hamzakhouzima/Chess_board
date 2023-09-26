package ChessGame;
import java.util.List;
import java.util.ArrayList;
public class Pawn extends Piece{
    protected Boolean moved;

    public Pawn(Color color) {
        super(color);
    }
/////////////////////////////////////////////////////////////////////////
public List<Spot> validPawnMoves(Spot currentSpot, Color color, Board board) {
    List<Spot> validMoves = new ArrayList<>();

    int x = currentSpot.getX();
    int y = currentSpot.getY();

    int direction = (color == Color.WHITE) ? 1 : -1;

    // Move one square forward
    Spot frontSpot = board.getSpot(x, y + direction);
    if (frontSpot != null && frontSpot.isEmpty()) {
        validMoves.add(frontSpot);
    }

    // Move two squares forward on the first move
    if ((color == Color.WHITE && y == 2) || (color == Color.BLACK && y == 7)) {
        Spot twoSquaresAhead = board.getSpot(x, y + 2 * direction);
        if (twoSquaresAhead != null && twoSquaresAhead.isEmpty()) {
            validMoves.add(twoSquaresAhead);
        }
    }

    // Capture diagonally
    Spot leftDiagonal = board.getSpot(x - 1, y + direction);
    Spot rightDiagonal = board.getSpot(x + 1, y + direction);

    if (leftDiagonal != null && !leftDiagonal.isEmpty() && leftDiagonal.getPiece().getColor() != color) {
        validMoves.add(leftDiagonal);
    }

    if (rightDiagonal != null && !rightDiagonal.isEmpty() && rightDiagonal.getPiece().getColor() != color) {
        validMoves.add(rightDiagonal);
    }

    return validMoves;
}



////////////////////////////////////////////////////////////////////////

    @Override
    public void Move(Board board, Spot currentSpot, Spot targetSpot) {
// moves forward in it's first move , it takes another piece diagonally \/


    }


    public static boolean PawnMove(Board chessBoard, int x1, int y1, int x2, int y2) {
        Spot currentSpot = chessBoard.getSpot(x1, y1);
        Spot targetSpot = chessBoard.getSpot(x2, y2);

        // Check if there is a piece at the current spot
        if (currentSpot.isEmpty() || currentSpot.getPiece().getType() != PieceType.PAWN) {
            System.out.println("Invalid move: No pawn found at the specified spot.");
            return false;
        }

        // White pawn moves
        if (currentSpot.getPiece().getColor() == Color.WHITE) {
            if (x1 == x2 && y2 == y1 + 1 && targetSpot.isEmpty()) {
                System.out.println("Pawn moved to : " + x2 + "-" +y2);
                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();
                return true; // Pawn moves one square forward
            } else if (x1 == x2 && y2 == y1 + 2 && y1 == 2 && chessBoard.getSpot(x1, y1 + 1).isEmpty() && targetSpot.isEmpty()) {
                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();
                System.out.println("Pawn moved to : " + x2 + "-" +y2);
                return true; // Pawn moves two squares forward from the starting position
            } else if (Math.abs(x2 - x1) == 1 && y2 == y1 + 1 && !targetSpot.isEmpty() && targetSpot.getPiece().getColor() == Color.BLACK) {
                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();
                System.out.println("a black piece has been taken");
                return true; // Pawn captures a piece diagonally
            }
        }

        // Black pawn moves
        if (currentSpot.getPiece().getColor() == Color.BLACK) {
            if (x1 == x2 && y2 == y1 - 1 && targetSpot.isEmpty()) {
                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();

                System.out.println("Pawn moved to : " + x2 + "-" +y2);
                return true; // Pawn moves one square forward

            } else if (x1 == x2 && y2 == y1 - 2 && y1 == 7 && chessBoard.getSpot(x1, y1 - 1).isEmpty() && targetSpot.isEmpty()) {

                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();
                System.out.println("Pawn moved to : " + x2 + "-" +y2);

                return true; // Pawn moves two squares forward from the starting position
            } else if (Math.abs(x2 - x1) == 1 && y2 == y1 - 1 && !targetSpot.isEmpty() && targetSpot.getPiece().getColor() == Color.WHITE) {
                System.out.println("a white piece has been taken");

                targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the pawn
                currentSpot.vacateSpot();


                return true; // Pawn captures a piece diagonally
            }
        }

        System.out.println("Invalid move: The specified move is not allowed for a pawn.");
        return false;
    }



    @Override
    public void Take() {
        //it takes another piece diagonally \/
    }

    @Override
    public void Check() {

    }
    @Override
    public void isValidMove() {

    }
}
