/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author scott
 */
public class Screen {
    
    JFrame frame = new JFrame("MAZE.EXE");
    
    /**
     * Creates any necessary screen
     * @param url - url pathname for an image or gif
     */
    public void createScreen(String url){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.getContentPane().setBackground(Color.white);
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
