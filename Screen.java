package mazegame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Screen {
    
    private final JFrame frame = new JFrame("Maze.exe");
    
    /**
     * Creates any necessary screen
     * @param imageName - url pathname for an image or gif
     */
    public void createScreen(String imageName){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(this.getClass().getResource(imageName));
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     * if frame visibility is true then it sets it to false
     * if frame visibility is false then it sets it to true
     */
    public void visibility(){
        if(frame.isShowing()){ //if intro screen is visible
            frame.setVisible(false);
        }else{
            frame.setVisible(true);
        }
    }
    
}
