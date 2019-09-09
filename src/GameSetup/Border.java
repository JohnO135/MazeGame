package GameSetup;


import javax.swing.JFrame;

public class Border {
	
	public Border() {
		JFrame mainWindow = new JFrame("Lettuce Adventure: Grilled Redux");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
		mainWindow.setSize(800, 500);
		mainWindow.setLocationRelativeTo(null);
	}

}
