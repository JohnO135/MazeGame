package mazegame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MazeTile extends JPanel{
    int x;
    int y;
    
    public MazeTile(int x, int y){
        this.x = x;
        this.y = y;
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){ //Right Click
                    switch (MazeCreator.map[x][y]) {
                        case 0:
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            break;
                        case 2:
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            MazeCreator.exitMade = false;
                            break;
                        default:
                            setBackground(Color.BLACK);
                            MazeCreator.map[x][y] = 0;
                            break;
                    }
                }
                
                if(e.getButton() == MouseEvent.BUTTON3){ //Left Click
                    if(MazeCreator.exitMade){ // if exit is made already
                        if(MazeCreator.map[x][y] == 2){
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            MazeCreator.exitMade = false;
                        }
                    }
                    else{ // if exit is not made yet
                        if(MazeCreator.map[x][y] == 0 || MazeCreator.map[x][y] == 1){
                            setBackground(Color.GREEN);
                            MazeCreator.map[x][y] = 2;
                            MazeCreator.exitMade = true;
                        }
                    }
                }
            }
        });
        
    }
}
