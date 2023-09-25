package ChessGame;

public class Player {
    private Color color;
    private String name;
    private Game game;
    private Boolean Turn;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void setGame(Game game) {
        this.game = game;
        this.Turn = game.getisWhiteTurn(); // Now you can access game
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void makeMove(Board chessBoard, String pieceType, int startX, int startY, int targetX, int targetY) {
        Spot currentSpot = chessBoard.getSpot(startX, startY);

        if (this.game == null) {
            System.out.println("Game object not set for player: " + this.name);
            return;
        }

      /*  if (currentSpot.isEmpty() || currentSpot.getPiece().getColor() != this.getColor()) {
            System.out.println("Invalid move. There is no piece belonging to you at the starting spot.");
            return;
        }*/

        switch (pieceType) {
            case "Pawn":
                Pawn.PawnMove(chessBoard, startX, startY, targetX, targetY);
                break;
            case "Rook":
                Rook.RookMove(chessBoard, startX, startY, targetX, targetY);
                break;
            // Add cases for other piece types as needed
            default:
                System.out.println("Invalid piece type.");
                break;
        }

        // Assuming there's a method to switch turns
      //  switchTurns();
      //  game.setisWhiteTurn(!game.getisWhiteTurn()); // Toggle the isWhiteTurn value

    }

 /*   public void switchTurns() {
        // Assuming there's a method to switch turns in your Game class
        game.setisWhiteTurn(!game.getisWhiteTurn()); // Toggle the isWhiteTurn value
    }*/

}
