package ChessGame;

import java.util.List;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }
    public static List<Spot> validQueenMoves(Board board, Spot currentSpot) {
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
    public static boolean QueenMove(Board chessBoard, int x1, int y1, int x2, int y2) {
        Spot currentSpot = chessBoard.getSpot(x1, y1);
        Spot targetSpot = chessBoard.getSpot(x2, y2);

//   check if there is a piece in that spot
        if (currentSpot.isEmpty() || currentSpot.getPiece().getType() != PieceType.QUEEN) {
            System.out.println("Invalid move: No queen found at the specified spot.");
            return false;
        }

        //List<Spot> validMoves = currentSpot.getPiece().validMoves(chessBoard, currentSpot);
        ArrayList<Spot> validMoves = (ArrayList<Spot>) Queen.validQueenMoves(chessBoard,currentSpot);

        if (!validMoves.contains(targetSpot)) {
            System.out.println("Invalid move: The specified move is not allowed for a queen.");
            return false;
        }
        else{
            // Perform the move
            currentSpot.vacateSpot();
            targetSpot.occupySpot(currentSpot.getPiece());

            System.out.println("Queen moved to : " + x2 + "-" + y2);
            return true;
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
