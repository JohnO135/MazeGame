package mazegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author student
 */
public class MainMenu {
    
    static String menuURL = "Main_Menu.PNG";

    JFrame Menu = new JFrame("Maze.exe");
    JButton Start = new JButton("Play Game");
    JButton MazeCreator = new JButton("Maze Creator");
    JButton Exit = new JButton("Exit Game");
    ImageIcon instructions = new ImageIcon(this.getClass().getResource(menuURL));
    JLabel imageLabel = new JLabel(instructions);
    ArrayList<String> mapList;
    JComboBox<String> numList;
    
    int buttonWidth = 150; // Width of each button
    int buttonHeight = 50;// Height of each button
    int menuY = 700; // Button location
    int WIDTH = 800;
    int HEIGHT = 800;

    public MainMenu() {
        this.mapList = new ArrayList<>();
        // Load map list
        getMapList();
        numList = new JComboBox<>(mapList.toArray(new String[mapList.size()]));

        // Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Start Button
        Start.setSize(buttonWidth,buttonHeight);
        Start.setLocation(40, menuY);
        Menu.add(Start);
        Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Maze(numList.getSelectedItem().toString());
                Menu.setVisible(false);
            }

        });

        // Maze Creator Button
        MazeCreator.setSize(buttonWidth,buttonHeight);
        MazeCreator.setLocation(215, menuY);
        Menu.add(MazeCreator);
        MazeCreator.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MazeCreator();
                Menu.setVisible(false);
            }

        });

        // Maze Selector
        numList.setSize(buttonWidth+35, buttonHeight);
        numList.setLocation(390, menuY);
        Menu.add(numList);

        // Exit Button
        Exit.setSize(buttonWidth,buttonHeight);
        Exit.setLocation(610,menuY);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Display Instructions Image
        imageLabel.setBounds((WIDTH-700)/2, 80, 700, 550);
        imageLabel.setVisible(true);
        Menu.add(imageLabel);
        Menu.setVisible(true);
    }

    static boolean mazeNumExistAlready = false;

    /**
     * Retrieves all maze map created/saved
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
}
