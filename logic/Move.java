public class Move {
    // a move contains the tiles to be added to the board and at what location
    // this object will allow the checking of words, removing of letters from player, and adding letters to board to be streamlined
    
    public Move () {
        
    }
    
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
            return this.tile;
        }
  
        private Tile tile;
        private int row, col;
    } 
    
    private List<TileCoords> tilecoords; // list of tile and coordinates container class
}