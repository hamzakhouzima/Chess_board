package ChessGame;

import java.awt.*;

public abstract class Piece {

     protected boolean taken;
     protected String position;
     protected Color color;

     public Piece(Color color) {
          this.color = color;
          this.taken = false;
          this.position = ""; // Initialize the position as empty
     }

     public Color getColor() {
          return color;
     }

     public abstract void Move(Board board, Spot currentSpot, Spot targetSpot);

     public abstract void Take();

     public abstract void Check();

     public abstract void isValidMove();

     public void setPosition(Spot spot) {
          // Update the position of the piece based on the spot it occupies
          this.position = String.valueOf((char) (spot.getX() + 'a' - 1)) + spot.getY();
     }
}
