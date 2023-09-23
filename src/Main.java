/*import ChessGame.;*/
import ChessGame.*;
import ChessGame.Color;

import java.awt.*;
//import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Board chessBoard = new Board();
        int x1 =2;
        int y1=2;

        int x2 =1;
        int y2 = 3;
       setupInitialPieces(chessBoard);
        // so i can move my pieces each piece have it's valid moves inside its class, validMoves returns and object of spots
        //where the piece can  go to , so by providing new coordinates , the piece will change its coordination's and occupy the new spot
        //also it should clear the previouse spot
 /*       Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();*/
        //about the user inputs it'll be as e3,e4,qd6, do the coordination will be string
        // to achieve that i need to create a converter that converts the string into int and also determin which piece will be moved

          //Knight.MoveKnight(chessBoard, x1,y1,x2,y2);
           Pawn.PawnMove(chessBoard, x1,y1,x2,y2);


//System.out.println( Knight.validKnightMoves(chessBoard,chessBoard.getSpot(4,4)));


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
        try {
            Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            System.out.println("Setup completed");

        } catch (InterruptedException e) {
            // Handle the exception if needed
        }
    }

    public static void MoveRook(Board chessBoard,int x1,int y1,int x2 , int y2){

        Spot currentSpot = chessBoard.getSpot(x1, y1); // this current spot i'll need to make a log file to track the spots and the position of each piece
        Spot targetSpot = chessBoard.getSpot(x2, y2);

        ArrayList<Spot> validMoves = (ArrayList<Spot>) Rook.validRookMoves(currentSpot, chessBoard);

        //System.out.println("Valid moves:");
        for (Spot move : validMoves) {
            if (move.getPiece() != null && move.getPiece().getColor() == currentSpot.getPiece().getColor()) {
                // Skip spots with pieces of the same color
                continue;
            }
            System.out.println(move);
        }

        if (validMoves.contains(targetSpot)) {
            System.out.println("Valid move!");
        } else {
            System.out.println("Invalid move!");
        }

    }



    }

