import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.GameManager;
import entity.ScreenManager;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		//Initialize the game manager
		GameManager.init();
		
		//Ask the user if they have a previous save file
		if(JOptionPane.showConfirmDialog(null, "Do you have a previous save file?") == JOptionPane.YES_OPTION)
				GameManager.loadPreviousGame();	// if so, display the file chooser to point to the location
			else
				GameManager.createNewGame(); // if not, create a new game
		
		//Display the main screen
		ScreenManager.showMainScreen();
		
	}

}
