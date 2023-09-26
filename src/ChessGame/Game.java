package ChessGame;

import java.util.Scanner;

public class Game {
    private Board chessBoard;
 /*   int x1;
    int y1;
    int x2;
    int y2;*/

    private Player whitePlayer;
    private Player blackPlayer;
    private boolean isWhiteTurn ; // Indicates whose turn it is

    // Constructor and other methods...
    public Game(Board board , Player whitePlayer , Player blackPlayer ){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.chessBoard = board;

    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }
  public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public  Boolean getisWhiteTurn(){
        return this.isWhiteTurn;
}
    public void startGame(String piece ,int x1 ,int y1 , int x2, int y2) {
         // White goes first
     isWhiteTurn = true;


        while (!isGameFinished()) {
            int count = 0;
            Player currentPlayer = isWhiteTurn ? whitePlayer : blackPlayer;
            count++;
            if(isWhiteTurn) {
                // White player's turn
                System.out.println("--------White plays");
                currentPlayer.makeMove(chessBoard ,piece, x1 , y1 ,x2 , y2); // You'll need to implement this method

            } else {
                // Black player's turn
                System.out.println("-------Black plays");

                currentPlayer.makeMove(chessBoard ,piece, x1 , y1 ,x2 , y2); // You'll need to implement this method

                if(count==1){
                    break;

                }
            }

            // Print the board or update the display
            // Check for checkmate or stalemate conditions, if necessary

            isWhiteTurn = !isWhiteTurn; // Switch turns
            System.out.println(isWhiteTurn);
        }

        // Game finished, determine the winner or outcome
    }

    public static boolean isGameFinished() {
        // Implement the condition for game termination (e.g., checkmate or stalemate)
        // Return true if the game is finished, false otherwise
    return false;
    }

    public void setisWhiteTurn(boolean isWhiteTurn) {
        System.out.println("White TURN");
        this.isWhiteTurn = isWhiteTurn;
    }
    public int[] promptForMove() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting x coordinate: ");
        int x1 = scanner.nextInt();

        System.out.print("Enter starting y coordinate: ");
        int y1 = scanner.nextInt();

        System.out.print("Enter target x coordinate: ");
        int x2 = scanner.nextInt();

        System.out.print("Enter target y coordinate: ");
        int y2 = scanner.nextInt();

        return new int[]{x1, y1, x2, y2};
    }
    public static String promptForPiece() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter piece type (e.g., Pawn, Rook, etc.): ");
        return scanner.nextLine();
    }

}
