/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class GameWindow {
    
    private JFrame frame; //Game window
    private Canvas canvas; //Canvas to display graphics
    
    private String title;
    private int width;
    private int height;
    
    public GameWindow(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        
        createWindow();
    }
    
    private void createWindow()
    {
        //Creates the frame that the game will be in
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //setting up canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height)); //Canvases only take dimensions for size setting
        //ensures the size of the canvas isn't resizable
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false); //Only focuses on the JFrame
        
        //add canvas within the frame
        frame.add(canvas);
        frame.pack(); //Ensures we wee the full canvas from within the window
        
    }
    
    public Canvas getCanvas()
    {
      return canvas;  //Allows other classes to have access to this canvas
    }
    
    public JFrame getJFrame()
    {
        return frame;
    }
    
}

