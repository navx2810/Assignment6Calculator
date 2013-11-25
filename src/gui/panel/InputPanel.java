package gui.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import entity.ScreenManager;

public class InputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411916676212388342L;
	private JButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnConfirm, btnErase;
	
	public InputPanel(){
		
		setLayout(new GridLayout(4, 3));
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new BtnAction());
		btnZero = new JButton("0");
		btnZero.addActionListener(new BtnAction());
		btnOne = new JButton("1");
		btnTwo = new JButton("2");
		btnThree = new JButton("3");
		btnFour = new JButton("4");
		btnFive = new JButton("5");
		btnSix = new JButton("6");
		btnSeven = new JButton("7");
		btnEight = new JButton("8");
		btnNine = new JButton("9");
		btnErase = new JButton("Delete");
		
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
				System.out.println("erase the last number");
			else if(e.getSource() == btnConfirm)
				System.out.println("confirm the answer");
			else 
				ScreenManager.mainScreen.inputAnswer(Integer.parseInt(temp.getText()));
		}
		
	}

}
