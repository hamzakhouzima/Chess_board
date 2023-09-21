/*import ChessGame.;*/
import ChessGame.*;
import ChessGame.Color;

import java.awt.*;
//import java.awt.Color;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Board chessBoard = new Board();
        setupInitialPieces(chessBoard);
        // so i can move my pieces each piece have it's valide moves inside its class, validMoves returns and object of spots
        //where the piece can  go to , so by providing new coordinates , the piece will change its coordination's and occupy the new spot
        //also it should clear the previouse spot
 /*       Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();*/
        //about the user inputs it'll be as e3,e4,qd6, do the coordination will be string
        // to achieve that i need to create a converter that converts the string into int and also determin which piece will be moved
      /*  String algebraicNotation = "a1";
        int[] coordinates = convertAlgebraicToCoordinates(algebraicNotation);
        int x = coordinates[0];
        int y = coordinates[1];
        System.out.println("Algebraic Notation: " + algebraicNotation);
        System.out.println("Coordinates (x, y): " + x + ", " + y);
*/       Spot currentSpot = chessBoard.getSpot(5, 2); // e2
         Spot targetSpot = chessBoard.getSpot(4, 3); // e4

         Piece pieceToMove = currentSpot.getPiece();
         pieceToMove.Move(chessBoard, currentSpot, targetSpot);





    }

    public static int[] convertAlgebraicToCoordinates(String algebraicNotation) {
        // Ensure the input is a valid algebraic notation
        if (algebraicNotation.length() != 2) {
            throw new IllegalArgumentException("Invalid algebraic notation: " + algebraicNotation);
        }

        char fileChar = algebraicNotation.charAt(0); // Letter (a-h)
        char rankChar = algebraicNotation.charAt(1); // Number (1-8)

        // Check if the characters are within valid ranges
        if (fileChar < 'a' || fileChar > 'h' || rankChar < '1' || rankChar > '8') {
            throw new IllegalArgumentException("Invalid algebraic notation: " + algebraicNotation);
        }

        int x = fileChar - 'a' + 1; // Convert letter to x-coordinate (1-8)
        int y = '8' - rankChar + 1; // Convert number to y-coordinate (1-8)

        int[] coordinates = {x, y};
        return coordinates;
    }

    public static void setupInitialPieces(Board chessBoard) {
        //////////////////////////////////////////WHITE/////////////////////////////////////////////////
        chessBoard.occupySpot(1, 1, new Rook(Color.WHITE));
        chessBoard.occupySpot(2, 1, new Knight(Color.WHITE));
        chessBoard.occupySpot(3, 1, new Bishop(Color.WHITE));
        chessBoard.occupySpot(4, 1, new Queen(Color.WHITE));
        chessBoard.occupySpot(5, 1, new King(Color.WHITE));
        chessBoard.occupySpot(6, 1, new Bishop(Color.WHITE));
        chessBoard.occupySpot(7, 1, new Knight(Color.WHITE));
        chessBoard.occupySpot(8, 1, new Rook(Color.WHITE));

        for (int i = 1; i <= 8; i++) {
            chessBoard.occupySpot(i, 2, new Pawn(Color.WHITE));
        }
        ///////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////BLACK/////////////////////////////////////////////////
        chessBoard.occupySpot(1, 8, new Rook(Color.BLACK));
        chessBoard.occupySpot(2, 8, new Knight(Color.BLACK));
        chessBoard.occupySpot(3, 8, new Bishop(Color.BLACK));
        chessBoard.occupySpot(4, 8, new Queen(Color.BLACK));
        chessBoard.occupySpot(5, 8, new King(Color.BLACK));
        chessBoard.occupySpot(6, 8, new Bishop(Color.BLACK));
        chessBoard.occupySpot(7, 8, new Knight(Color.BLACK));
        chessBoard.occupySpot(8, 8, new Rook(Color.BLACK));

        for (int i = 1; i <= 8; i++) {
            chessBoard.occupySpot(i, 7, new Pawn(Color.BLACK));
        }
        ///////////////////////////////////////////////////////////////////////////////////////////
    }





    }

