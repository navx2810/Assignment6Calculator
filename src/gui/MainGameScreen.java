package gui;

import entity.GameManager;
import entity.QuestionManager;
import gui.panel.InputPanel;
import gui.panel.MathDisplayPanel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainGameScreen extends JFrame {

	private static final long serialVersionUID = 6902929393853109753L;
	private JPanel contentPanel, simpleMathPanel, fractionMathPanel, remainingQuestionsPanel;
	private JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem menuItemSave, menuItemLoad, menuItemQuit;
	private JLabel remainingQuestionsLabel;
	private InputPanel inputPanel;
	private MathDisplayPanel mathDisplayPanel;
	private int currentAnswerSlot = 0;
	
	public MainGameScreen() 
	{
		setTitle("Learning Math");
		setSize(248,350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		buildContentPanel();
		
	}

	private void buildContentPanel() 
	{
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		contentPanel.setLayout(new BorderLayout());
		setContentPane(contentPanel);
		
		buildSimpleMathPanel();
		buildFractionMathPanel();
		buildTabbedPane();
		buildMenuBar();
		
	}

	private void buildMenuBar() 
	{
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		menuItemLoad = new JMenuItem("Load");
		menuItemLoad.setMnemonic(KeyEvent.VK_L);
		menuItemQuit = new JMenuItem("Quit");
		menuItemQuit.setMnemonic(KeyEvent.VK_Q);
		menuItemSave = new JMenuItem("Save");
		menuItemSave.setMnemonic(KeyEvent.VK_S);
		
		fileMenu.add(menuItemSave);
		fileMenu.add(menuItemLoad);
		fileMenu.add(menuItemQuit);
		
		menuBar.add(fileMenu);
		
		contentPanel.add(menuBar,BorderLayout.NORTH);
	}

	private void buildFractionMathPanel() 
	{
		fractionMathPanel = new JPanel(new BorderLayout());
	}

	private void buildSimpleMathPanel() 
	{
		simpleMathPanel = new JPanel(new BorderLayout());
		
		mathDisplayPanel = new MathDisplayPanel();
		
		
		inputPanel = new InputPanel();
		
		remainingQuestionsPanel = new JPanel(new BorderLayout());
		remainingQuestionsPanel.setBorder(new EmptyBorder(0,2,5,0));
		remainingQuestionsLabel = new JLabel("remainingQuestions");
		remainingQuestionsPanel.add(remainingQuestionsLabel, BorderLayout.WEST);
		
		simpleMathPanel.add(inputPanel, BorderLayout.SOUTH);
		simpleMathPanel.add(remainingQuestionsPanel, BorderLayout.NORTH);
		simpleMathPanel.add(mathDisplayPanel,BorderLayout.CENTER);
	}

	private void buildTabbedPane() 
	{
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Simple", simpleMathPanel);
		tabbedPane.addTab("Fractions", fractionMathPanel);
		
		contentPanel.add(tabbedPane, BorderLayout.CENTER);
	}

	public void getNextQuestion(){
		QuestionManager.loadNextQuestion();
		mathDisplayPanel.buildQuestion();
	}

	public void redrawPanels(){
		buildSimpleMathPanel();
		buildFractionMathPanel();
	}
	
	public void inputAnswer(int x){
		if(currentAnswerSlot < 2){
		mathDisplayPanel.buildAnswer(x,currentAnswerSlot);
		GameManager.currentAnswer.insert(0, x);
		currentAnswerSlot++;
		}
	}
	
	public void removeAnswer(){
		if(currentAnswerSlot > 0){
			mathDisplayPanel.removeAnswer(currentAnswerSlot-1);
			GameManager.currentAnswer.deleteCharAt(0);
			currentAnswerSlot--;
		}
	}
}
