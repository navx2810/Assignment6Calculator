package entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import resources.Assests;


public class GameManager implements Serializable {
	
	private static final long serialVersionUID = 4923970702381591282L;
	public static String  playerName;
	public static StringBuilder currentAnswer = new StringBuilder();
	public static QuestionManager questionManager;
	public static File gameFile;
	static JFileChooser chooser = new JFileChooser();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter("Trivia Game Data", "tgd");
	
	
	/** This method is used to initialize the GameManager
	 * 
	 */
	public static void init(){
		Assests.build();
		buildQuestions();
	}
	
	private static void buildQuestions() {
		
	}

	/** This method will prompt the user for their name and create a new QuestionManager.
	 * 
	 */
	public static void createNewGame(){
		GameManager.playerName = JOptionPane.showInputDialog(null, "What is your name?");
		QuestionManager.createNewQuestionManager();
	}
	
	/** This method will load the previous game file
	 * @throws FileNotFoundException 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void loadPreviousGame() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
		gameFile = chooser.getSelectedFile();
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(gameFile));
		playerName = inputStream.readUTF();
		questionManager = (QuestionManager) inputStream.readObject();
		inputStream.close();
		} else 
			createNewGame();
	}
	
	/** This method will display a fileChooser and ask where the user would like to save the file
	 * then will save the file to that location
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveGame() throws FileNotFoundException, IOException{
		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			gameFile = chooser.getSelectedFile();
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(gameFile));
			outputStream.writeUTF(playerName);
			outputStream.writeObject(questionManager);
			outputStream.close();
		} 
		
	}

	public static void completeGame() {
		// Tally score
		// Display score
		// Ask the user if they want to save or play again
	}
}
