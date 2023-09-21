/*import ChessGame.;*/
import ChessGame.*;
import ChessGame.Color;

import java.awt.*;
//import java.awt.Color;

public class Main {
    public static void main(String[] args) {

        Board chessBoard = new Board();
        setupInitialPieces(chessBoard);
        // so i can move my pieces each piece have it's valide moves inside it's class, validMoves returns and object of spots
        //where the piece can  go to , so by providing new coordinates , the piece will change it's coordination's and occupy the new spot
        //also it should clear the previouse spot


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

