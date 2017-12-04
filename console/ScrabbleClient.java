import java.util.*;

public class ScrabbleClient {
    public static void main(String[] args) {
        Board board = new Board("data/default.board");
        LetterStack letterStack = new LetterStack("data/default.tiles");
        WordList wordList = new WordList("data/dictionary.txt");
              
        // initialize all the players with their own tiles from the letter stack
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            players.add(new Player(letterStack));
        }
        
        // start the game
        Scrabble scrabble = new Scrabble(board, letterStack, wordList, players);
        System.out.println("Winner: "+scrabble.getWinner().getName());
    }
}