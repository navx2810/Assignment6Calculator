package entity;

import gui.MainGameScreen;

public class ScreenManager {
	public static MainGameScreen mainScreen = new MainGameScreen();
	
	public static void showMainScreen(){
		mainScreen.setVisible(true);
	}
}
