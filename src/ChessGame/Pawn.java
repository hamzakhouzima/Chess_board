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
