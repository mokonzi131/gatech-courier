package mcuserpane;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MCCanvas extends JPanel {
	private int _width, _height;
	private Color _paperBG, _paperLine;
	private MCModel _model;
	
	protected MCCanvas(MCModel model) {		
		_model = model;
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
		drawModel((Graphics2D)g);
	}
	
	private void drawPaper(Graphics g) {
		g.setColor(_paperBG);
		g.fillRect(0, 0, _width, _height);
		g.setColor(_paperLine);
		for (int i = 0; i < _height; i += 25)
			g.drawLine(0, i, _width, i);
		String pageNumber = "" + _model.currentPageNumber();
		g.drawString(pageNumber, _width - 20, _height - 10);
	}
	
	private void drawModel(Graphics2D g) {
		// setup pen
		Stroke oldStroke = g.getStroke();
		BasicStroke myStroke =
				new BasicStroke(
						4.0f,
						BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND);
		g.setStroke(myStroke);
		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.addRenderingHints(hints);
		
		// draw list of stored items
		for (MCObject object : _model._objects)
			object.render(g);
		
		// draw current shape
		if (_model._drawingShape != null)
			_model._drawingShape.render(g);
		
		// draw current control points
		if (_model._drawingStartPoint != null)
			drawControlPoint(g, _model._drawingStartPoint);
		if (_model._drawingCurrentPoint != null)
			drawControlPoint(g, _model._drawingCurrentPoint);
		
		// replace old pen
		g.setStroke(oldStroke);
	}
	
	private void drawControlPoint(Graphics2D g, Point2D.Double point) {
		final int SIZE = 10;
		g.setColor(Color.GREEN);
		g.fillOval((int)point.x - SIZE/2, (int)point.y - SIZE/2, SIZE, SIZE);
		g.setColor(Color.RED);
		g.drawOval((int)point.x - SIZE/2, (int)point.y - SIZE/2, SIZE, SIZE);
	}
}
