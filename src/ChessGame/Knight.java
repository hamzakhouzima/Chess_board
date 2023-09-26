package ChessGame;
import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);

    }
    public  List<Spot> validKnightMoves(Board board, Spot currentSpot) {
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

  /*       System.out.println("knight can move to ");

                 System.out.println(newX);
                System.out.println(newY);
            System.out.println("_______________________________________");

*/

            if (spot != null && (spot.isEmpty() || spot.getPiece().getColor() != currentSpot.getPiece().getColor())) {
                validMoves.add(spot);

            }
        }

        return validMoves;
    }


    @Override
    public void Move(Board board, Spot currentSpot, Spot targetSpot) {

    }
    public  void KnightMove(Board chessBoard, int x1, int y1, int x2, int y2){
        Spot currentSpot = chessBoard.getSpot(x1, y1); // this current spot i'll need to make a log file to track the spots and the position of each piece
        Spot targetSpot = chessBoard.getSpot(x2, y2);

        ArrayList<Spot> validMoves = (ArrayList<Spot>) this.validKnightMoves(chessBoard,currentSpot);



        System.out.println(currentSpot.getX());
        System.out.println(currentSpot.getX());
        System.out.println("________________________________________________________________");
        System.out.println(targetSpot.getX());
        System.out.println(targetSpot.getY());


        //System.out.println("Valid moves:");
        for (Spot move : validMoves) {
            //move in this foreach represente  each valid move
            if (move.getPiece() != null && move.getPiece().getColor() == currentSpot.getPiece().getColor()) {
                // Skip spots with pieces of the same color
                continue;
            }

        }

        if (validMoves.contains(targetSpot)) {
            System.out.println("Valid move!");

        } else {
            System.out.println("Invalid move!");
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
