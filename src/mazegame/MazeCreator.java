package mazegame;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static mazegame.MazeGame.introURL;


public class MazeCreator extends JFrame{
    static int rows = 20;
    static int col = 20;
    int panelSize = 25;
    int mazeNum = 0;
    boolean mazesExistAlready = false;
    static boolean exitMade = false; // make sure only 1 exit is made
    static int map[][] = new int[col][rows]; //maze array 
    ArrayList<String> mapList = new ArrayList<>();
    
    public MazeCreator(){
        getMazeList();
        getMaze();
        if(mazeNum != -1){
            loadMaze();
            this.setResizable(false);
            this.setSize((col * panelSize)+55, (rows * panelSize)+80); //width, height
            this.setTitle("Maze Creator: Exit Window To Save Maze");
            this.setLayout(null);

            this.addWindowListener(new WindowAdapter(){ //close window to save maze
                @Override
                public void windowClosing(WindowEvent e) {
                    saveMaze();
                    MainMenu main = new MainMenu();
                    main.createMain(introURL);
                }
            });

            this.setLocationRelativeTo(null); //makes window in the center

            for(int y = 0; y < col; y++){
                for(int x = 0; x < rows; x++){
                    MazeTile tile = new MazeTile(x, y);
                    tile.setSize(panelSize-1, panelSize-1);
                    tile.setLocation((x*panelSize)+23, (y*panelSize)+25);
                    switch (map[x][y]) {
                        /*
                        0 - black (wall)
                        1 - white (maze route)
                        2 - green (maze exit)
                        */
                        case 0:
                            tile.setBackground(Color.BLACK);
                            break;
                        case 2:
                            tile.setBackground(Color.GREEN);
                            break;
                        default:
                            tile.setBackground(Color.WHITE);
                            break;
                    }
                    tile.setVisible(true);
                    this.add(tile);
                }
            }
            this.setVisible(true);
        }else{
            MainMenu main = new MainMenu();
            main.createMain(introURL);
        }
    }
    
    private void getMazeList(){
        for(int i = 0; i < 99; i++){
            File map = new File("./Maze " + i); //Maze map file is created
            if(map.exists()){
                mapList.add("Maze " + i);
                mazesExistAlready = true;
            }
        }
    }
    
    private void getMaze(){
        if(mazesExistAlready){
            String maps[] = new String[99];
            mapList.toArray(maps);
            maps[mapList.size()] = "New Maze";
            String choice = (String)JOptionPane.showInputDialog(null, null, null, 
                    JOptionPane.QUESTION_MESSAGE, null, maps, maps[0]);
            if(choice != null && !choice.equals("New Maze")){
                mazeNum = Integer.parseInt(choice.replace("Maze ", ""));
            }
            else if(choice == null){
                mazeNum = -1;
            }
            else{
                mazeNum = mapList.size();
            }
        }
    }
    
    public void saveMaze(){
        try{
            PrintWriter writer = new PrintWriter("Maze " + mazeNum, "UTF-8");
            for(int y = 0; y < col; y++){
                for(int x = 0; x < rows; x++){
                    writer.print(map[x][y]);
                }
                writer.print("\r\n");
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void loadMaze(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Maze " + mazeNum));
            StringBuilder sBuilder = new StringBuilder();
            String line = reader.readLine();
            while(line != null){
                sBuilder.append(line);
                sBuilder.append(System.lineSeparator());
                line = reader.readLine();
            }
            String mapString = sBuilder.toString();
            int counter = 0;
            for(int y = 0; y < col; y++){
                for(int x = 0; x < rows; x++){
                    String mapChar = mapString.substring(counter, counter + 1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){
                        map[x][y] = Integer.parseInt(mapChar);
                    }
                    else{
                        x--;
                    }
                    counter++;
                }
            }
        }catch(Exception e){
            System.out.println("Creating a new map.");
            for(int y = 0; y < col; y++){
                for(int x = 0; x < rows; x++){
                    map[x][y] = 0;
                }
            }
        }
    }
}
