
import javax.swing.JPanel;

public class Tile extends JPanel{
    int x, y;
    boolean isWall = true;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Set the tile as a wall marker
     * @param isWall - boolean to set if the tile is a wall (0)
     */
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
}
