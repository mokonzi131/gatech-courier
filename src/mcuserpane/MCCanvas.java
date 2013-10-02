package mcuserpane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MCCanvas extends JPanel {
	private int _width, _height;
	private Color _paperBG, _paperLine;
	
	protected MCCanvas() {		
		this.setBorder(new LineBorder(Color.BLACK, 2));
		_width = 500;
		_height = 500;	
		_paperBG = new Color(255, 253, 117);
		_paperLine = new Color(71, 136, 255);
		this.setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(_width, _height);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawPaper(g);
	}
	
	private void drawPaper(Graphics g) {
		g.setColor(_paperBG);
		g.fillRect(0, 0, _width, _height);
		g.setColor(_paperLine);
		for (int i = 0; i < _height; i += 25)
			g.drawLine(0, i, _width, i);
	}
}
