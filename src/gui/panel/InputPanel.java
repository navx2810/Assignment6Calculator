package gui.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import entity.QuestionManager;
import entity.ScreenManager;

public class InputPanel extends JPanel {

	private static final long serialVersionUID = 6411916676212388342L;
	private JButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnConfirm, btnErase;
	
	public InputPanel(){
		
		setLayout(new GridLayout(4, 3));
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new BtnAction());
		btnZero = new JButton("0");
		btnZero.addActionListener(new BtnAction());
		btnOne = new JButton("1");
		btnOne.addActionListener(new BtnAction());
		btnTwo = new JButton("2");
		btnTwo.addActionListener(new BtnAction());
		btnThree = new JButton("3");
		btnThree.addActionListener(new BtnAction());
		btnFour = new JButton("4");
		btnFour.addActionListener(new BtnAction());
		btnFive = new JButton("5");
		btnFive.addActionListener(new BtnAction());
		btnSix = new JButton("6");
		btnSix.addActionListener(new BtnAction());
		btnSeven = new JButton("7");
		btnSeven.addActionListener(new BtnAction());
		btnEight = new JButton("8");
		btnEight.addActionListener(new BtnAction());
		btnNine = new JButton("9");
		btnNine.addActionListener(new BtnAction());
		btnErase = new JButton("Delete");
		btnErase.addActionListener(new BtnAction());
		
		add(btnOne);
		add(btnTwo);
		add(btnThree);
		add(btnFour);
		add(btnFive);
		add(btnSix);
		add(btnSeven);
		add(btnEight);
		add(btnNine);
		add(btnErase);
		add(btnZero);
		add(btnConfirm);
		
	}
	
	private class BtnAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton temp = (JButton) e.getSource();
			if(e.getSource() == btnErase)
				ScreenManager.mainScreen.removeAnswer();
			else if(e.getSource() == btnConfirm){
				QuestionManager.checkAnswer();
				ScreenManager.mainScreen.getNextQuestion();
			}
				
			else 
				ScreenManager.mainScreen.inputAnswer(Integer.parseInt(temp.getText()));
		}
		
	}

}
