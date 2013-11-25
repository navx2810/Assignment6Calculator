package gui;

import gui.panel.InputPanel;
import gui.panel.MathDisplayPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import resources.Assests;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 8546989593173292789L;
	private JPanel contentPane;
	private InputPanel inputPanel;
	private MathDisplayPanel mathDisplayPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assests.build();
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		inputPanel = new InputPanel();
		mathDisplayPanel = new MathDisplayPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(248,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel simpleMathPanel = new JPanel();
		tabbedPane.addTab("Simple", null, simpleMathPanel, null);
		simpleMathPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel questionsRemainingPanel = new JPanel();
		questionsRemainingPanel.setBorder(new EmptyBorder(0, 2, 5, 0));
		simpleMathPanel.add(questionsRemainingPanel, BorderLayout.NORTH);
		questionsRemainingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblQuestionsremaining = new JLabel("questionsRemaining");
		lblQuestionsremaining.setVerticalAlignment(SwingConstants.TOP);
		lblQuestionsremaining.setHorizontalAlignment(SwingConstants.LEFT);
		questionsRemainingPanel.add(lblQuestionsremaining);
		simpleMathPanel.add(mathDisplayPanel, BorderLayout.CENTER);
		simpleMathPanel.add(inputPanel, BorderLayout.SOUTH);
		
		JPanel fractionMathPanel = new JPanel();
		tabbedPane.addTab("Fraction", null, fractionMathPanel, null);
		fractionMathPanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic(KeyEvent.VK_S);
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.setMnemonic(KeyEvent.VK_L);
		mnFile.add(mntmLoad);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
	}

}
