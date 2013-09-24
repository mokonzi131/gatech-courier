package mcgui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MCCanvas extends JPanel {
	protected MCCanvas() {
		this.setBackground(Color.WHITE);
		
		this.setBorder(new LineBorder(Color.BLACK, 2));
		this.setPreferredSize(new Dimension(500, 500));
	}
}
