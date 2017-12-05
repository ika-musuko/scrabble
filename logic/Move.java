public class Move {
    // a move contains the tiles to be added to the board and at what location
    // this object will allow the checking of words, removing of letters from player, and adding letters to board to be streamlined
    
    // these constructors are private because all Moves should be valid or null. use the factory functions to create Move objects
    
    // constructor for generating moves from a string and orientation
    private Move(String s, Board b, int r, int c, int orientation) {
        
    }
    
    // constructor for generating a move for a single tile
    private Move(Tile t, Board b, int r, int, c) {
        
    }
     
    // factory functions for creating moves because invalid moves should be null
    // whole word factory generating a move from a Board, an existing word, and an orientation
    // useful for console front end and testing
    // only adds moves not existing on the board
    public static Move makeWordMove(String s, Board b, int r, int c, int orientation) {
        // construct a M
        Move move = new Move(s, b, r, c, orientation);
        List<
        
        move.tilecoords.removeAll(conflicts);
        return move;
    }
    
    // single tile factory
    
    public void updateMove(Tile t, int r, int c) {
        this.tilecoords.add(new TileCoords(t, r, c));
    }
    
    class TileCoords {
        public TileCoords(Tile tile, int r, int c) {
            this.row = r;
            this.col = c;
            this.tile = tile;
        }
        
        public int getR() {
            return this.row;
        }
  
        public int getC() {
            return this.col;
        }
        
        public Tile getTile() {
            return this.row;
        }
  
        private Tile tile;
        private int row, col;
    } 
    
    private List<TileCoords> tilecoords; // list of tile and coordinates container class
}