import java.util.*;

public class Scrabble { 
    public Scrabble (Board board, LetterStack letterStack, WordList wordList, List<Player> players) {
        this.players = players;
        this.board = board;
        this.letterStack = letterStack;
        this.wordList = wordList;
        
        this.finished = false; 
        
        this.currentTurn = 0;
        this.play();
    }
    
    public Player getWinner() {
        return Collections.max(this.players);
    }
    
    public void play() {
        Player currentPlayer = this.players.get(currentTurn);
        
    }
    
    private List<Player> players;
    private int currentTurn;
    
    private LetterStack letterStack;
    private Board board;
    private WordList wordList;
    
    private boolean finished;
}