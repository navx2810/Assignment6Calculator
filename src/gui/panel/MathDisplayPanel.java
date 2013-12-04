package gui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.Assests;
import resources.Assests.Mode;
import entity.GameManager;
import entity.QuestionManager;

public class MathDisplayPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 52395739811456656L;
	public JLabel[] labels = new JLabel[12];
	public int currentAnswerSlot;

	
	public MathDisplayPanel(){

		setLayout(new GridLayout(4, 3,0,0));
		
		for(int x=0; x<labels.length; x++)
			labels[x] = new JLabel(Assests.getIcon(Mode.BLANK));
		
		for(int x=0; x<labels.length; x++)
			add(labels[x]);
		
		buildQuestion();
	}
	
	/** This method is used to build the current question sitting inside the QuestionManager
	 * @see QuestionManager
	 */
	public void buildQuestion(){
		String[] temp = GameManager.questionManager.currentQuestion.question.split(" ");	//Split the question into an array
		
		for(int x=0; x<temp[0].length(); x++){		// set the top layer icons of the grid to their corresponding value
			int position = (temp[0].length()-1)-x;	
			int value = Integer.parseInt(String.valueOf(temp[0].charAt(position)));
			labels[2-x].setIcon(Assests.getIcon(value));
		}
		
		Mode currentMode;
		
		if(temp[1].equals("+"))		// Determine the current mode of this question
			currentMode = Mode.ADDITION;
		else if(temp[1].equals("-"))
			currentMode = Mode.SUBTRACTION;
		else if(temp[1].equals("/"))
			currentMode = Mode.DIVISION;
		else
			currentMode = Mode.MULTIPLICATION;
		
		labels[3].setIcon(Assests.getIcon(currentMode));	// Set the icon for this mode '+' will be a plus icon. . .
		
		for(int x=0; x<temp[2].length(); x++){		// Cycle through and place the second layer icons with corresponding value
			int position = (temp[2].length()-1)-x;
			int value = Integer.parseInt(String.valueOf(temp[2].charAt(position)));
			labels[5-x].setIcon(Assests.getIcon(value));
		}
		
		for(int x=6; x<9; x++)		// Cycle through the third layer and set their icons to 'Lines'
			labels[x].setIcon(Assests.getIcon(Mode.LINE));
		
		for(int x=9; x<12; x++)		// Cycle through the last layer and set their icons to 'blanks'
			labels[x].setIcon(Assests.getIcon(Mode.BLANK));
	}
	
	/** Set the value of the next available slot of the for the value the player has entered
	 * @param value - the value the player entered
	 * @param slot - the current slot available
	 */
	public void buildAnswer(int value, int slot){
				labels[11-slot].setIcon(Assests.getIcon(value));
	}
	
	/** Set the value of the previously used slot to blank 
	 * @param slot - the current slot being used
	 */
	public void removeAnswer(int slot){
			labels[11-slot].setIcon(Assests.getIcon(Mode.BLANK));
			
	}
	
}
