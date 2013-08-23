package mcgui;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AppPane extends JPanel {
	public void initialize() {
		this.add(new JLabel("Hello World Left!"));
	}
}
