import java.util.*;

// console front end for scrabble, mainly to easily test logic
public class ScrabbleClient {
    
    class ConsolePlayer extends ConcretePlayer {
        
        public Move makeMove(Board b) {
            // reset deltas
            this.dr = 0;
            this.dc = 0;
            
            System.out.println(this.name+"'s Turn");
            System.out.println("Tray: "+this.tray())
            
            // get user input
            // row and col
            System.out.println("Enter a row and column to start placing a word at: ");
            int row = -1; int col = -1;
            Scanner in = new Scanner(System.in);
            try {
                row = in.nextInt();
                col = in.nextInt();
            } catch (IOException e) {
                System.out.println("Invalid position input... IOException");
                return null;
            }
            if (!b.inBounds(row, col)) {
                System.out.println("Invalid position input... OutOfBounds");
                return null;
            }

            // word
            System.out.println("Enter a word: ");
            String word = "";
            try {
                word = in.nextLine();
            } catch (IOException e) {
                System.out.println("Invalid word input...");
                return null;
            }
            
            // orientation
            System.out.println("Enter orientation (0 for horizontal and 1 for vertical)");
            try {
                
            }
            
            // this will either return a move or null if it is invalid
            return Move.makeWordMove(word, b, row, col, orientation);
        }
    }
    
    public static void main(String[] args) {
        Board board = new Board("../data/default.board");
        LetterStack letterStack = new LetterStack("../data/default.tiles");
        WordList wordList = new WordList("../data/dictionary.txt");
              
        // initialize all the players with their own tiles from the letter stack
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            players.add(new ConsolePlayer("Player "+i));
        }
        
        // start the game
        Scrabble scrabble = new Scrabble(board, letterStack, wordList, players);
        scrabble.init();
        System.out.println("Winner: "+scrabble.getWinner().getName());
    }
}