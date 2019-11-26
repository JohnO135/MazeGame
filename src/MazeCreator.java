
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MazeCreator extends JFrame{
    final static int rows = 20;
    final static int columns = 20;
    int panelSize = 25;
    static int map[][] = new int[columns][rows];
    ArrayList<String> mapList;
    int mazeNum = 0;
    boolean mazeNumExistAlready = false;
    static boolean exitMade = false; // make sure only one exit is made 

    public MazeCreator(){
        this.mapList = new ArrayList<>();
        getMapList();
        getMazeNumChoice();
        if(mazeNum != -1){
            loadMap();
            this.setResizable(false);
            this.setSize((columns*panelSize)+50, (rows*panelSize)+70);
            this.setTitle("Maze Creator: Exit Window To Save Maze");
            this.setLayout(null);

            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    saveMap();
                    new MainMenu();
                }
            });

            this.setLocationRelativeTo(null);

            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    MazeTile tile = new MazeTile(x, y);
                    tile.setSize(panelSize-1, panelSize-1);
                    tile.setLocation((x*panelSize)+23, (y*panelSize)+25);
                    switch (map[x][y]) {
                        case 3:
                            tile.setBackground(Color.YELLOW);
                            break;
                        case 2:
                            tile.setBackground(Color.GREEN);
                            break;
                        case 1:
                            tile.setBackground(Color.WHITE);
                            break;
                        default:
                            tile.setBackground(Color.GRAY);
                            break;
                    }
                    tile.setVisible(true);
                    this.add(tile);
                }
            }
            this.setVisible(true);
        }else{
            new MainMenu();
        }
    }

    /**
     * Retrieves the maze maps created/saved
     */
    public void getMapList(){
        for(int i = 0; i < 99; i++){
            File map = new File("./Maze " + i);
            if(map.exists()){
                System.out.println("Maze " + i + " exists");
                mapList.add("Maze " + i);
                mazeNumExistAlready = true;
            }
        }
    }

    /**
     * Based on selection, it retrieves the maze according to its number 
     */
    public void getMazeNumChoice(){
        if(mazeNumExistAlready){
            String maps[] = new String[99];
            mapList.toArray(maps);
            maps[mapList.size()] = "New maze";
            String choice = (String)JOptionPane.showInputDialog(null, "Which map would you like to play?", "Maze Selector", JOptionPane.QUESTION_MESSAGE, null, maps, maps[0]);
            System.out.println(choice);
            if(choice != null && !choice.equals("New maze")){
                mazeNum = Integer.parseInt((choice.replace("Maze ", "")));
            }else if(choice == null){
                mazeNum = -1;
            }else{
                mazeNum = mapList.size();
            }
        }
    }

    /**
     * Saves the map the user creates to a file (consists of 0,1,2)
     */
    public void saveMap(){
        try{
            PrintWriter writer;
            writer = new PrintWriter("Maze " + mazeNum, "UTF-8");
            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    writer.print(map[x][y]);
                }
                writer.print("\r\n");
            }
            writer.close();
        }catch(FileNotFoundException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    /**
     * Load the saved maze maps, based on the 0,1,2 numbers
     */
    public void loadMap(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Maze " + mazeNum));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String mapStr = sb.toString();

            int counter = 0;
            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    String mapChar = mapStr.substring(counter, counter+1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){//If it's a number
                        map[x][y] = Integer.parseInt(mapChar);
                    }else{//If it is a line break
                        x--;
                    }
                    counter++;
                }
            }
        }catch(IOException | NumberFormatException e){
            System.out.println("Unable to load existing maze(if exists), creating new maze.");
            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    map[x][y] = 0;
                }
            }
        }
    }
}
