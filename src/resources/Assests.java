package resources;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** This class is used to access the icons that are loaded.
 *
 */
public class Assests {
	public enum Mode {
		ADDITION(14), SUBTRACTION(13), MULTIPLICATION(12), DIVISION(11), BLANK(10), LINE(15);
		int value;
		private Mode(int value) {
			this.value = value;
		}
	}

	public static Icon[] icons = new ImageIcon[17];

	/** This method will initially load the icons
	 * 
	 */
	public static void build() {
		for (int x = 0; x < icons.length; x++)
			icons[x] = new ImageIcon(Assests.class.getResource("icons/" + x
					+ ".png"));
	}

	/** This method returns an icon of the given value
	 * @param x - the value for the icon
	 * @return - the icon 
	 */
	public static Icon getIcon(int x) {
		return icons[x];
	}
	
	/** This method will returns an icon of the given mode
	 * @param mode - the current mode
	 * @return - the icon
	 */
	public static Icon getIcon(Mode mode){
		return icons[mode.value];
	}

}
