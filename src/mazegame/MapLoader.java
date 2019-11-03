/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author theme
 */
public class MapLoader {
    
    private File compressedMap;
    private Game game;
    private double gridWidth, gridHeight;
    private double tileSizeHeight,tileSizeWidth;
    private Scanner in;
    
    public MapLoader(Game ingame, String mapName) {
        game = ingame;
        try {
            compressedMap = new File("C:\\Users\\John\\Documents\\NetBeansProjects\\MazeGame\\MazeGame\\" + mapName);
            in = new Scanner(compressedMap);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        gridWidth = ingame.width;
        gridHeight = ingame.height;
        tileSizeHeight = gridHeight/20;
        tileSizeWidth = gridWidth/20;
    }
    
    public void render(Graphics g) {
        int x = 0;
        int y = 0;
        while(in.hasNext())
        {
            if(in.next() == "1"){
                g.drawRect(x,y,(int)tileSizeWidth,(int)tileSizeHeight);
            }
            if(in.next() == "0") {
                x += (int)tileSizeWidth;
            }
            if(in.next() == "\n") {
                y += (int)tileSizeHeight;
            }
        }
    }
    
    public void tick() {
        
    }
    
    
}
