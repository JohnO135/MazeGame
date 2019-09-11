/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author scott
 */
public class MainMenu {
    private JFrame frame = new JFrame("MAZE.EXE");
    private JPanel pane;
    private JButton playButton;
    private JButton exitButton;
    
    /**
     * Creates any necessary screen
     * @param imageName - url pathname for an image or gif
     */
    public void createMain(String imageName){
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
        SwingUtilities.invokeLater(new MainMenu()::showButtons);
    }
    
    public void showButtons(){
        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        
        playButton = new JButton("Play Game");
        exitButton = new JButton("Exit Game");
        
        pane.add(playButton);
        pane.add(Box.createHorizontalGlue());
        pane.add(exitButton);
        
        frame.add(pane, BorderLayout.SOUTH);
    }
    
}
