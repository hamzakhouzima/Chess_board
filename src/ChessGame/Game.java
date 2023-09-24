package ChessGame;

public class Game {
    private Board chessBoard;
    int x1;
    int y1;
    int x2;
    int y2;

    private Player whitePlayer;
    private Player blackPlayer;
    private boolean isWhiteTurn; // Indicates whose turn it is

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
            if (isWhiteTurn) {
                // White player's turn
                whitePlayer.makeMove(chessBoard ,piece, x1 , y1 ,x2 , y2); // You'll need to implement this method
            } else {
                // Black player's turn
                blackPlayer.makeMove(chessBoard ,piece, x1 , y1 ,x2 , y2); // You'll need to implement this method
            }

            // Print the board or update the display
            // Check for checkmate or stalemate conditions, if necessary

            isWhiteTurn = !isWhiteTurn; // Switch turns
        }

        // Game finished, determine the winner or outcome
    }

    private boolean isGameFinished() {
        // Implement the condition for game termination (e.g., checkmate or stalemate)
        // Return true if the game is finished, false otherwise
    return false;
    }
}
