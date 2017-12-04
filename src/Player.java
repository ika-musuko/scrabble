import java.lang.*;
import java.util.*;

public class Player implements Comparable<Player>{
    public Player(String name) {
        
    }
    
    // fill tray from ls
    // true -> success
    // false -> failure
    public boolean fillTray(LetterStack ls) {
        boolean lettersExist = !ls.empty();
        for(int i = 0; lettersExist && i < tray.remainingLetters(); ++i){
            this.tray.add(ls.pop());
        }
        return lettersExist;
    }
    
    // place tile on board
    public boolean placeTile(Board b, int tileIndex, int r, int c) {
        // no overlaps / sanity check
        Tile playTile = this.tray.remove(tileIndex);
        if (playTile == null || b.isFilled(r, c)) 
            return false;  
        // play the tile on the board
        b.setTile(playTile, r, c);
        return true;
    }
    
    // remove tile from board into player's tray (only current turn tile)
    public boolean removeTile(Board b, int r, int c) {
        // can't remove a nonexistent tile or past tile
        Tile boardTile = b.getTile(r, c);
        if (boardTile == null || boardTile.tileStatus() == Tile.PAST)
            return false;
        this.tray.add(b.popTile(r, c));
        return true;
    }
    
    public int compareTo(Player other) {
        
    }
    
    private int score;
    private Tray tray;
}