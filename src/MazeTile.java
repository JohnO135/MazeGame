
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MazeTile extends JPanel{
    int x, y;

    public MazeTile(int x, int y){
        this.x = x;
        this.y = y;

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){ // right click for path/wall tile only
                    switch (MazeCreator.map[x][y]) {
                        case 0:
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            break;
                        case 1:
                            setBackground(Color.GRAY);
                            MazeCreator.map[x][y] = 0;
                            break;
                        case 2:
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            MazeCreator.exitMade = false;
                            break;
                        default:
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            break;
                    }
                }
                if(e.getButton() == MouseEvent.BUTTON3){ // left click for exit tile (only 1 is made)
                    if(MazeCreator.exitMade){
                        if(MazeCreator.map[x][y] == 1){
                            setBackground(Color.YELLOW);
                            MazeCreator.map[x][y] = 3;
                            //MazeCreator.exitMade = false;
                        }
                        if(MazeCreator.map[x][y] == 2){
                            setBackground(Color.WHITE);
                            MazeCreator.map[x][y] = 1;
                            MazeCreator.exitMade = false;
                        }
                    }else{
                        setBackground(Color.GREEN);
                        MazeCreator.map[x][y] = 2;
                        MazeCreator.exitMade = true;
                    }
                }
            }
        });
    }
}
