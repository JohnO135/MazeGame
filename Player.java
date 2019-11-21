package mazegame;

import java.awt.Color;
import javax.swing.JPanel;

public class Player extends JPanel{
    int x, y;

    public Player() {
        this.setBackground(Color.BLUE); // player will be a blue square
        this.setSize(Maze.panelSize, Maze.panelSize);
    }
    
    /*
    player can only move on tiles that are represented 
    by 1 (path tile) and 2 (exit tile) only
    */

    public void moveLeft() {
        if(x > 0 && (Maze.map[x-1][y] == 1 || Maze.map[x-1][y] == 2)){
            this.setLocation(this.getX()-25, this.getY());
            x--;
        }
    }

    public void moveRight() {
        if(x < Maze.columns-1 && (Maze.map[x+1][y] == 1 || Maze.map[x+1][y] == 2)){
            this.setLocation(this.getX()+25, this.getY());
            x++;
        }
    }

    public void moveUp() {
        if(y > 0 && (Maze.map[x][y-1] == 1 || Maze.map[x][y-1] == 2)){
            this.setLocation(this.getX(), this.getY()-25);
            y--;
        }
    }

    public void moveDown() {
        if(y < Maze.rows-1 && (Maze.map[x][y+1] == 1 || Maze.map[x][y+1] == 2)){
            this.setLocation(this.getX(), this.getY()+25);
            y++;
        }
    }
}
