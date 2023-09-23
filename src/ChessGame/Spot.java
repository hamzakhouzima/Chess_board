package ChessGame;

public class Spot {
    private int x;
    private int y;
    private Piece piece;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null; // Initially, the spot is empty
    }
    public Boolean isEmpty() {
        return piece == null ; // Check if the spot's piece is null (empty)
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public  void occupySpot(Piece piece) {
        this.piece = piece;
        //this is a setter fo the piece
    }
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void vacateSpot() {
        this.piece = null;
    }

}
