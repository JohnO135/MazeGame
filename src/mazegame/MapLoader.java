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
    private double boardWidth, boardHeight;
    private double tileHeight, tileWidth;
    private Scanner in;
    
    
    
    public MapLoader(Game ingame, File map) {
        game = ingame;
        compressedMap = map;
        boardWidth = game.width;
        boardHeight = game.height;
        tileHeight = boardHeight/20;
        tileWidth = boardWidth/20;
        try {
            in = new Scanner(compressedMap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void render(Graphics g) {
        
    }
    
    public void tick() {
        
    }
    
    
}
