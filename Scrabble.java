public class Scrabble {
    
    public Scrabble (List<Tile> tiles, Board board, int totalPlayers) {
        // make the letter stack from the tile list
        this.letterStack = new LetterStack(tiles);
        
        // initialize all the players with their own tiles from the letter stack
        this.players = new ArrayList<>();
        for (int i = 0; i < totalPlayers; ++i) {
            this.players.add(new Player(this.letterStack));
        }
        
        // initialize the board
        this.board = board;
    }
    
    
    
    private List<Player> players;
    private LetterStack letterStack;
    private Board board;
}