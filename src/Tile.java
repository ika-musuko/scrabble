import java.lang.*;

class Tile {
    public Tile(char letter, int score) {
        this.letter = letter;
        this.score = score;
    }

    public int getLetter() {
        return this.letter;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public String toString() {
        return Character.toString(this.letter);
    }
    
    protected char letter;
    protected int score;   
}

class BlankTile extends Tile {
    public BlankTile() {
        super(" ", 0);
    }
    
    public void setLetter(char letter) {
        this.letter = letter;
    }
    
}