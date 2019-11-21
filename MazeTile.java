
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
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    setBackground(Color.WHITE);
                    MazeCreator.map[x][y] = 1;
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    setBackground(Color.GRAY);
                    MazeCreator.map[x][y] = 0;
                }
            }
        });
    }
}
