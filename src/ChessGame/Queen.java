package ChessGame;

import java.util.List;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }
    public static List<Spot> validQueenMoves(Board board, Spot currentSpot) {
        List<Spot> validMoves = new ArrayList<>();
 /*       int x = currentSpot.getX();
        int y = currentSpot.getY();*/

        // Add valid moves for a rook (horizontally and vertically)
        validMoves.addAll(Rook.validRookMoves(currentSpot,board));

        // Add valid moves for a bishop (diagonally)
        validMoves.addAll(Bishop.validBishopMoves(board, currentSpot));

        return validMoves;
    }

    @Override
    public void Move(Board board, Spot currentSpot, Spot targetSpot) {

    }
    public static void QueenMove(Board chessBoard, int x1, int y1, int x2, int y2) {
        Spot currentSpot = chessBoard.getSpot(x1, y1);
        Spot targetSpot = chessBoard.getSpot(x2, y2);
        List<Spot> validMoves =  Queen.validQueenMoves(chessBoard,currentSpot);

//   check if there is a piece in that spot
     /*   if (currentSpot.isEmpty() ) {
            System.out.println("Invalid move: No queen found at the specified spot.");
            return false;
        }
//|| currentSpot.getPiece().getType() != PieceType.QUEEN
        //List<Spot> validMoves = currentSpot.getPiece().validMoves(chessBoard, currentSpot);

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
        }*/

        System.out.println("Number of valid moves: " + validMoves.size());

        if (!validMoves.isEmpty()) {
            System.out.println("List of valid moves: ");
            for (Spot move : validMoves) {
                System.out.println("(" + move.getX() + ", " + move.getY() + ")");
            }
        } else {
            System.out.println("No valid moves available.");
        }

        if (validMoves.contains(targetSpot)) {
            System.out.println("Valid Queen move!");
            targetSpot.occupySpot(currentSpot.getPiece()); // Occupy the target spot with the rook
            currentSpot.vacateSpot();
        } else {
            System.out.println("Invalid Queen move!");
            if (targetSpot != null) {
                System.out.println("Target spot is occupied: " + !targetSpot.isEmpty());
            } else {
                System.out.println("Target spot is null.");
            }
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
