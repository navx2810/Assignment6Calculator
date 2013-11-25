package entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import resources.Assests;


public class GameManager implements Serializable {
	
	private static final long serialVersionUID = 4923970702381591282L;
	public static String  playerName;
	public static QuestionManager questionManager;
	public static File gameFile;
	static JFileChooser chooser = new JFileChooser();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter("Trivia Game Data", "tgd");
	
	
	public static void init(){
		Assests.build();
		buildQuestions();
	}
	
	private static void buildQuestions() {
		
	}

	public static void createNewGame(){
		GameManager.playerName = JOptionPane.showInputDialog(null, "What is your name?");
	}
	
	public static void loadPreviousGame(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		playerName = inputStream.readUTF();
		questionManager = (QuestionManager) inputStream.readObject();
		gameFile = file;
		inputStream.close();
	}
	
	public static void saveGame(){
		
	}
}
