/**
 * LoadMap class that will load the Maze map. Same dimensions as MainMenu screen.
 */

package mazegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoadMap {

    private JFrame frame = new JFrame("MAZE.EXE");
    private JPanel pane;
    private JButton exitButton;

    public void createMap(String imageName){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(this.getClass().getResource(imageName));
        JLabel label = new JLabel(icon);
        frame.add(label);

        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

        exitButton = new JButton("Exit Game");


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pane.add(exitButton);
        pane.add(Box.createHorizontalGlue());

        frame.add(pane, BorderLayout.SOUTH);

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
