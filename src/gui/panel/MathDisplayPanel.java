package gui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.Assests;
import resources.Assests.Mode;
import entity.QuestionManager;

public class MathDisplayPanel extends JPanel {

//	public static JLabel 	TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, 
//							MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT,
//							BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 52395739811456656L;
	public JLabel[] labels = new JLabel[12];
	public int currentAnswerSlot;

	
	public MathDisplayPanel(){

		setLayout(new GridLayout(4, 3));
		
//		TOP_LEFT = new JLabel();
//		TOP_MIDDLE = new JLabel(Assests.ICON_ONE);
//		TOP_RIGHT = new JLabel(Assests.ICON_ONE);
//		MIDDLE_LEFT = new JLabel(Assests.ICON_ADDITION);
//		MIDDLE_MIDDLE = new JLabel();
//		MIDDLE_RIGHT = new JLabel(Assests.ICON_TWO);
//		BOTTOM_LEFT = new JLabel();
//		BOTTOM_MIDDLE = new JLabel();
//		BOTTOM_RIGHT = new JLabel();
//		
//		add(TOP_LEFT);
//		add(TOP_MIDDLE);
//		add(TOP_RIGHT);
//		add(MIDDLE_LEFT);
//		add(MIDDLE_MIDDLE);
//		add(MIDDLE_RIGHT);
//		add(BOTTOM_LEFT);
//		add(BOTTOM_MIDDLE);
//		add(BOTTOM_RIGHT);
		
		for(int x=0; x<labels.length; x++)
			labels[x] = new JLabel(Assests.getIcon(Mode.BLANK));
		
		for(int x=0; x<labels.length; x++)
			add(labels[x]);
		
//		buildQuestion(new Question("12 + 4","16")); //TODO Remove this
		buildQuestion();
	}
	
	public void buildQuestion(){
		String[] temp = QuestionManager.currentQuestion.question.split(" ");
		
		for(int x=0; x<temp[0].length(); x++){
			int position = (temp[0].length()-1)-x;
			int value = Integer.parseInt(String.valueOf(temp[0].charAt(position)));
			labels[2-x].setIcon(Assests.getIcon(value));
		}
		
		Mode currentMode;
		
		if(temp[1].equals("+"))
			currentMode = Mode.ADDITION;
		else if(temp[1].equals("-"))
			currentMode = Mode.SUBTRACTION;
		else if(temp[1].equals("/"))
			currentMode = Mode.DIVISION;
		else
			currentMode = Mode.MULTIPLICATION;
		
		labels[3].setIcon(Assests.getIcon(currentMode));
		
		for(int x=0; x<temp[2].length(); x++){
			int position = (temp[2].length()-1)-x;
			int value = Integer.parseInt(String.valueOf(temp[2].charAt(position)));
			labels[5-x].setIcon(Assests.getIcon(value));
		}
		
		for(int x=6; x<9; x++)
			labels[x].setIcon(Assests.getIcon(Mode.LINE));
		
		for(int x=9; x<12; x++)
			labels[x].setIcon(Assests.getIcon(Mode.BLANK));
	}
	
	public void buildAnswer(int value, int slot){
				labels[11-slot].setIcon(Assests.getIcon(value));
	}
	
	public void removeAnswer(int slot){
			labels[11-slot].setIcon(Assests.getIcon(Mode.BLANK));
			
	}
	
}
