/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class MainMenu {
    private final JFrame frame = new JFrame("MAZE.EXE");
    private JPanel pane;
    private JButton playButton;
    private JButton exitButton;
    private JButton mazeCreatorButton;
    private JComboBox<String> lvlList;
    private ArrayList<String> mapList = new ArrayList<String>();

    static String mazeGif = "maze.gif"; //NOT NECESSARY
    
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
        
        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        
        getMapList();
        lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));


        /**
         * Added functionality to the Play Game button.
         * The user will be redirected to the Maze screen or start of the game.
         */
        playButton = new JButton("Play Game");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Maze maze = new Maze(lvlList.getSelectedItem().toString());
                frame.setVisible(false);
            }
        });
        /**
         * Added functionality to the Exit Game button.
         * Will close the current screen.
         */
        exitButton = new JButton("Exit Game");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * Added functionality to the Map Creator button.
         * Allow user to create maze maps by clicking squares.
         */
        mazeCreatorButton = new JButton("Maze Creator");
        mazeCreatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MazeCreator();
                frame.setVisible(false);
            }
        });
        
        pane.add(playButton);
        pane.add(Box.createHorizontalGlue());
        pane.add(mazeCreatorButton);
        pane.add(Box.createHorizontalGlue());
        pane.add(exitButton);
        pane.setBackground(Color.WHITE);
        
        frame.add(pane, BorderLayout.SOUTH);
        
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    } //end of CreateMain method
    
    static boolean levelsExistAlready = false;

    public void getMapList(){
        for(int i = 0; i < 99; i++){
            File map = new File("./Level "+i+".map");
            if(map.exists()){
                System.out.println("Level "+i+" exists");
                mapList.add("Level "+i+".map");
                levelsExistAlready = true;
            }
        }
    }
    


}//end of class MainMenu
