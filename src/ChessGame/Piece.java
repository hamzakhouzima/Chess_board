package ChessGame;

import java.awt.*;

public abstract class Piece {

     protected Boolean Taken ;

     protected String position ;

     protected Color color;




     public Piece(Color color) {

     }

     public Color getColor() {
          return color;
     }

     public abstract void Move(Board board, Spot currentSpot, Spot targetSpot);

     public abstract void Take();

     public abstract void Check();

     public abstract void isValidMove();

}
