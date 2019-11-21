
import java.awt.Color;
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
    
    static String introURL = "Main_Menu.PNG";

    JFrame Menu = new JFrame("Maze.EXE");
    JButton Start = new JButton("Play Game");
    JButton Exit = new JButton("Exit Game");
    JButton MazeCreator = new JButton("Maze Creator");
    ImageIcon picture = new ImageIcon(this.getClass().getResource(introURL));
    JLabel imageLabel = new JLabel(picture);
    ArrayList<String> mapList = new ArrayList<String>();
    JComboBox<String> lvlList;
    int menuWidth = 150; //Width of each button/item on display
    int menuHeight = 50;//Height of each button/item on display
    int menuY = 700; //Button/item location on display
    int WIDTH = 800;
    int HEIGHT = 800;

    public MainMenu() {
        //Load map list
        getMapList();
        lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));

        //Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        //Start Button Variables
        Start.setSize(menuWidth,menuHeight);
        Start.setLocation(40, menuY);
        Menu.add(Start);
        Start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Maze(lvlList.getSelectedItem().toString());
                Menu.setVisible(false);
            }

        });

        //Maze Creator Button Variables
        MazeCreator.setSize(menuWidth,menuHeight);
        MazeCreator.setLocation(215, menuY);
        Menu.add(MazeCreator);
        MazeCreator.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new MazeCreator();
                Menu.setVisible(false);
            }

        });

        //Maze Selector
        lvlList.setSize(menuWidth+35, menuHeight);
        lvlList.setLocation(390, menuY);
        Menu.add(lvlList);

        //Exit Button Variables
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(610,menuY);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //Display Picture
        imageLabel.setBounds((WIDTH-700)/2, 80, 700, 550);
        imageLabel.setVisible(true);
        Menu.add(imageLabel);
        Menu.setVisible(true);

    }

    static boolean mazeNumExistAlready = false;

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
