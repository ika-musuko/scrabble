import java.util.*;

public class Tray extends ArrayList<Tile> {
    public final static int DEFAULT_SIZE = 7;
    public Tray(int size) {
        super();
        this.size = size;
    }
    public Tray() {
        this(Tray.DEFAULT_SIZE);
    }
    
    public String toString() {
        return "<"+Arrays.deepToString(this.toArray())+">";
    }
    
    private int size;
}