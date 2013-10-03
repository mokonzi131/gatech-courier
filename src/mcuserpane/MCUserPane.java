package mcuserpane;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import mcgui.MockCourierWindow;

@SuppressWarnings("serial")
public class MCUserPane extends JPanel implements MouseListener, MouseMotionListener {	
	private MCCanvas _canvas;
	private MCCanvasControls _canvasControls;
	protected MCModel _model;
		
	public MCUserPane() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// setup the model
		_model = new MCModel();
		
		// setup the canvas
		_canvas = new MCCanvas(_model);
		_canvas.addMouseListener(this);
		_canvas.addMouseMotionListener(this);
		this.add(_canvas);
		
		// setup the page controls
		JPanel pageControls = new JPanel();
		pageControls.add(new JButton("New Page"));
		pageControls.add(new JButton("Delete Page"));
		pageControls.add(new JButton("Page Forward"));
		pageControls.add(new JButton("Page Backward"));
		this.add(pageControls);
		
		// setup the canvas controls
		_canvasControls = new MCCanvasControls();
		this.add(_canvasControls);
		
		this.setVisible(true);
	}
	
	// canvas mouse event listeners (controller - user input)
	@Override public void mouseDragged(MouseEvent e) {		
		Point point = e.getPoint();
		Point2D.Double point2 = new Point2D.Double(point.getX(), point.getY());
		
		_model._drawingCurrentPoint = point2;
		if (_model._drawingShape != null)
			_model._drawingShape.update(point2);
		_canvas.repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}

	@Override public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override public void mousePressed(MouseEvent e) {
		MCCanvasControls.MODE mode = _canvasControls.currentMode();
		
		Point point = e.getPoint();
		Point2D.Double point2 = new Point2D.Double(point.getX(), point.getY());
		switch (mode) {
		case FREE:
			_model._drawingShape = new MCOFree(point2);
			break;
		case RECT:
			_model._drawingShape = new MCORectangle(point2, point2);
			break;
		case OVAL:
			_model._drawingShape = new MCOOval(point2, point2);
			break;
		case TEXT:
			_model._drawingShape = new MCOText(point2, point2);
			break;
		default:
			break;
		}
		
		_model._drawingStartPoint = point2;
		_canvas.repaint();
	}

	@Override public void mouseReleased(MouseEvent e) {
		// add our new shape to the list
		if (_model._drawingShape != null) {
			_model._drawingShape.create();
			_model._objects.add(_model._drawingShape);
		}
		
		// release all current drawing resources
		_model._drawingStartPoint = null;
		_model._drawingCurrentPoint = null;
		_model._drawingShape = null;
		
		// call damage
		_canvas.repaint();
	}

	@Override public void mouseEntered(MouseEvent e) {
		MockCourierWindow.getInstance().setStatus("INSIDE");
	}

	@Override public void mouseExited(MouseEvent e) {
		MockCourierWindow.getInstance().setStatus("OUTSIDE");
	}
}
