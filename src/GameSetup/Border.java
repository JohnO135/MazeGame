package GameSetup;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

public class Border{
	
	public Border() {
		JFrame mainWindow = new JFrame("Lettuce Adventure: Grilled Redux");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(800,500));
		mainWindow.setLocationRelativeTo(null);
		mainWindow.getContentPane().setBackground(Color.GREEN);
		mainWindow.pack();
		mainWindow.setVisible(true);
		
	}

}
