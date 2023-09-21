package ChessGame;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class Board {

    private Spot[][] spots ;
    private String[] alphabet = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };
    private Piece piece;

    public Board() {
        // initialize the chessboard with Spot objects
        spots = new Spot[8][8];
        for (int x = 1; x <= 8; x++) {
            for (int y = 0; y < 8; y++) {
                spots[x - 1][y] = new Spot(x, y);
               //System.out.println( y + " "+alphabet[y]+ " "+x);
            }
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public void occupySpot(int x, int y, Piece piece) {


        // Occupy a Spot with a Piece
        Spot spot = getSpot(x, y);
        if (spot != null) {
            spot.occupySpot(piece);
        } else {
            // Handle invalid positions gracefully
            System.out.println("Invalid position (" + x + ", " + y + ")");
        }
    }


    public Spot getSpot(int x, int y) {
        // Return the Spot object at a specific position
        if (isValidPosition(x, y)) {
            return spots[x - 1][y - 1];
        } else {
            return null; // Handle invalid positions gracefully
        }
    }



}
