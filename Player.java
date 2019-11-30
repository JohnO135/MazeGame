package mazegame;

import java.awt.Color;
import javax.swing.JPanel;

public class Player extends JPanel{
    int x, y;

    public Player() {
        this.setBackground(Color.BLUE); // player will be a blue square
        this.setSize(MazeGame.panelSize, MazeGame.panelSize);
    }

    /**
     * Moves character to the left as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveLeft() {
        if(x > 0 && (MazeGame.map[x-1][y] == 1 || MazeGame.map[x-1][y] == 2)){
            this.setLocation(this.getX()-25, this.getY());
            x--;
        }
    }

    /**
     * Moves character to the right as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveRight() {
        if(x < MazeGame.columns-1 && (MazeGame.map[x+1][y] == 1 || MazeGame.map[x+1][y] == 2)){
            this.setLocation(this.getX()+25, this.getY());
            x++;
        }
    }

    /**
     * Moves character to up as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveUp() {
        if(y > 0 && (MazeGame.map[x][y-1] == 1 || MazeGame.map[x][y-1] == 2)){
            this.setLocation(this.getX(), this.getY()-25);
            y--;
        }
    }

    /**
     * Moves character to down as long as the tile is a 1 or a 2 
     * and not out of bounds
     */
    public void moveDown() {
        if(y < MazeGame.rows-1 && (MazeGame.map[x][y+1] == 1 || MazeGame.map[x][y+1] == 2)){
            this.setLocation(this.getX(), this.getY()+25);
            y++;
        }
    }
}
