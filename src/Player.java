
import java.awt.Color;
import javax.swing.JPanel;

public class Player extends JPanel{
    int x, y;

    public Player() {
        this.setBackground(Color.BLUE); // player will be a blue square
        this.setSize(Maze.panelSize, Maze.panelSize);
    }

    /**
     * Moves character to the left as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveLeft() {
        if(x > 0 && (Maze.map[x-1][y] == 1 || Maze.map[x-1][y] == 2 || Maze.map[x-1][y] == 3)){
            this.setLocation(this.getX()-25, this.getY());
            x--;
        }
    }

    /**
     * Moves character to the right as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveRight() {
        if(x < Maze.columns-1 && (Maze.map[x+1][y] == 1 || Maze.map[x+1][y] == 2  || Maze.map[x+1][y] == 3)){
            this.setLocation(this.getX()+25, this.getY());
            x++;
        }
    }

    /**
     * Moves character to up as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveUp() {
        if(y > 0 && (Maze.map[x][y-1] == 1 || Maze.map[x][y-1] == 2 || Maze.map[x][y-1] == 3)){
            this.setLocation(this.getX(), this.getY()-25);
            y--;
        }
    }

    /**
     * Moves character to down as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveDown() {
        if(y < Maze.rows-1 && (Maze.map[x][y+1] == 1 || Maze.map[x][y+1] == 2 || Maze.map[x][y+1] == 3)){
            this.setLocation(this.getX(), this.getY()+25);
            y++;
        }
    }
}
