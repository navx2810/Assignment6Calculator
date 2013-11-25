package resources;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Assests {
	public enum Mode {
		ADDITION(14), SUBTRACTION(13), MULTIPLICATION(12), DIVISION(11), BLANK(10), LINE(15);
		int value;
		private Mode(int value) {
			this.value = value;
		}
	}

	// public static Icon ICON_ONE = new
	// ImageIcon(Assests.class.getResource("icons/1.png"));
	// public static Icon ICON_TWO = new
	// ImageIcon(Assests.class.getResource("icons/2.png"));
	// public static Icon ICON_THREE = new
	// ImageIcon(Assests.class.getResource("icons/3.png"));
	// public static Icon ICON_FOUR = new
	// ImageIcon(Assests.class.getResource("icons/4.png"));
	// public static Icon ICON_FIVE = new
	// ImageIcon(Assests.class.getResource("icons/5.png"));
	// public static Icon ICON_SIX = new
	// ImageIcon(Assests.class.getResource("icons/6.png"));
	// public static Icon ICON_SEVEN = new
	// ImageIcon(Assests.class.getResource("icons/7.png"));
	// public static Icon ICON_EIGHT = new
	// ImageIcon(Assests.class.getResource("icons/8.png"));
	// public static Icon ICON_NINE = new
	// ImageIcon(Assests.class.getResource("icons/9.png"));
	// public static Icon ICON_ZERO = new
	// ImageIcon(Assests.class.getResource("icons/0.png"));
	// public static Icon ICON_ADDITION = new
	// ImageIcon(Assests.class.getResource("icons/+.png"));
	// public static Icon ICON_MULTIPLICATION = new
	// ImageIcon(Assests.class.getResource("icons/multiply.png"));
	// public static Icon ICON_DIVISION = new
	// ImageIcon(Assests.class.getResource("icons/divide.png"));
	// public static Icon ICON_BLANK = new
	// ImageIcon(Assests.class.getResource("icons/blank.png"));

	public static Icon[] icons = new ImageIcon[16];

	public static void build() {
		for (int x = 0; x < icons.length; x++)
			icons[x] = new ImageIcon(Assests.class.getResource("icons/" + x
					+ ".png"));
	}

	public static Icon getIcon(int x) {
		return icons[x];
	}
	
	public static Icon getIcon(Mode mode){
		return icons[mode.value];
	}

}
