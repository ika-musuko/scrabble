import java.util.*;
import java.lang.*;

public class Scrabble implements Runnable { 

    public Scrabble (Board board, LetterStack letterStack, WordList wordList, List<Player> players) {
        this.players = players;
        this.board = board;
        this.letterStack = letterStack;
        this.wordList = wordList;
        
        this.currentTurn = 0;
        
        this.init();
        this.play();
    }
    
    public Player getWinner() {
        return Collections.max(this.players);
    }
    
    private boolean letterFiller (Player p) {
        this.letterStack = p.fillTray(this.letterStack);
        return this.letterStack.isEmpty();
    }
    
    public void init() {
        for (Player p : this.players) {
            this.letterFiller(p);
        }
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
    
    // wait for a move from the current player
    private void waitForMove() throws NoSuchElementException {
        // holder for current move data
        Move move = null;
        
        // wait for a move
        do {
            move = this.currentPlayer.makeMove();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }    
        } while (move == null || !this.board.validMove(move)); // make sure the move is valid
        
        // perform move (and increase player's score accordingly)
        if(!this.currentPlayer.popLetters(move))
            throw new NoSuchElementException("At least one of the letters in the Move "+move+" were not found. "+this.currentPlayer.getName()+"'s tray data: "+this.currentPlayer.getTray());
        this.currentPlayer.addScore(board.performMove(move));
        
        // fill player tray
        this.letterFiller(this.currentPlayer);
    }
    
    // go to the next turn
    private void nextTurn() {
        this.currentPlayer = this.players.get(++this.currentTurn % this.players.size());
    }
    
    public boolean gameFinished() {
        if(!this.letterStack.isEmpty())
            return false;
        for (Player p : players) {
            if (p.trayEmpty()) return true;
        }
        return false;
    }
    
    private List<Player> players;
    private Player currentPlayer;
    private int currentTurn;
    
    private LetterStack letterStack;
    private Board board;
    private WordList wordList; 
}