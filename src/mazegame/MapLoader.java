/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Graphics;
import java.io.File;
/**
 *
 * @author theme
 */
public class MapLoader {
    
    private File compressedMap;
    private Game game;
    
    public MapLoader(Game ingame, File map) {
        game = ingame;
        compressedMap = map;
    }
    
    public void render(Graphics g) {
        
    }
    
    public void tick() {
        
    }
    
    
}
