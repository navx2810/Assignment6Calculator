import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import entity.GameManager;
import entity.ScreenManager;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		//Initialize the game manager
		GameManager.init();
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Trivia Game Data", "tgd","txt");
		chooser.setFileFilter(filter);
		
		//Ask the user if they have a previous save file
		if(JOptionPane.showConfirmDialog(null, "Do you have a previous save file?") == JOptionPane.YES_OPTION)
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				GameManager.loadPreviousGame(chooser.getSelectedFile());	// if so, display the file chooser to point to the location
			else
				GameManager.createNewGame(); // if not, create a new game
		else
				GameManager.createNewGame(); // if the user clicks cancel, create a new game
		
		//Display the main screen
		ScreenManager.showMainScreen();
		
	}

}
