import java.lang.*;
import java.util.*;

public interface Player implements Comparable<Player> {
    public int compareTo(Player other);
    
    public LetterStack exchangeLetters(LetterStack ls, List<Tile> toExchange);
    public LetterStack fillTray(LetterStack ls);
    public LetterStack popLetters(Move move);
    public boolean trayEmpty();
    
    public int getScore();
    
    public void addScore
    public Move getMove();
    public Move makeMove();
}

public abstract ConcretePlayer implements Player {
    public ConcretePlayer(String name, LetterStack ls) {
        this.name = name;
        this.score = 0;
        this.fillTray(ls);
    }
 
    // compare scores
    public int compareTo(Player other) {
        return (this.score - other.score);
    }
 
    // fill tray from ls
    // true -> success
    // false -> failure
    public LetterStack fillTray(LetterStack ls) {
        for(int i = 0; lettersExist && i < tray.remainingLetters(); ++i){
            this.tray.add(ls.pop());
        }
        return ls;
    }
    
    // pop letters off tray according to move
    public boolean popLetters(Move move) {
        
    }

    public boolean trayEmpty() {
        return tray.isEmpty();
    }
    
    public int getScore() {
        return this.score;
    }
    
    public Move getMove() {
        return this.move;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Tray getTray() {
        return this.tray;
    }
    
    // implement how to set a move depending on frontend
    public abstract Move makeMove();
    
    private int score;
    private Tray tray;
    private Move move;
    private String name; 
}