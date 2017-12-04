import java.util.*;

public class Scrabble implements Runnable { 
    public Scrabble (Board board, LetterStack letterStack, WordList wordList, List<Player> players) {
        this.players = players;
        this.board = board;
        this.letterStack = letterStack;
        this.wordList = wordList;
        
        this.currentTurn = 0;
        this.play();
    }
    
    public Player getWinner() {
        return Collections.max(this.players);
    }
    
    public void play() {
        // check if players are ready
        System.out.println("scrabble: waiting for players");
        while (!this.playersReady()) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }    
        }
        
        // set the starting player
        this.currentPlayer = this.players.get(currentTurn);
        
        // start game
        System.out.println("scrabble: starting game...");
        while (!this.gameFinished()) {
            this.waitForMove();
            this.nextTurn();
        }
    }
    
    private void waitForMove() {
        Move move = null;
        // wait for a move
        do {
            move = this.currentPlayer.getMove();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }    
        } while (move == null || !this.board.validMove(move));
        
        // perform move
        boolean 
            
    }
    
    public boolean gameFinished() {
        
    }
    
    private List<Player> players;
    private Player currentPlayer;
    private int currentTurn;
    
    private LetterStack letterStack;
    private Board board;
    private WordList wordList;
    
}