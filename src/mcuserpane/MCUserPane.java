package mcuserpane;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MCUserPane extends JPanel implements MouseListener, MouseMotionListener, KeyListener {	
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
		_canvas.setFocusable(true);
		_canvas.addKeyListener(this);
		this.add(_canvas);
		
		// setup the page controls
		JPanel pageControls = new JPanel();
		JButton delPage = new JButton("REMOVE PAGE");
		delPage.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				_model.deletePage();
				_canvas.repaint();
			}
		});
		JButton newpage = new JButton("INSERT PAGE");
		newpage.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				_model.newPage();
				_canvas.repaint();
			}
		});
		JButton backward = new JButton("<");
		backward.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				_model.back();
				_canvas.repaint();
			}
		});
		JButton forward = new JButton(">");
		forward.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				_model.forward();
				_canvas.repaint();
			}
		});
		pageControls.add(backward);
		pageControls.add(delPage);
		pageControls.add(newpage);
		pageControls.add(forward);
		this.add(pageControls);
		
		// setup the canvas controls
		_canvasControls = new MCCanvasControls();
		this.add(_canvasControls);
		
		this.setVisible(true);
	}
	
	// canvas mouse event listeners (controller - user input)
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseMoved(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {		
		Point point = e.getPoint();
		Point2D.Double point2 = new Point2D.Double(point.getX(), point.getY());
		
		_model.setDrawingCurrentPoint(point2);
		if (_model.drawingShape() != null)
			_model.drawingShape().update(point2);
		_canvas.repaint();
	}
	@Override public void mousePressed(MouseEvent e) {
		_model.setFocusShape(null);
		MCCanvasControls.MODE mode = _canvasControls.currentMode();
		
		Point point = e.getPoint();
		Point2D.Double point2 = new Point2D.Double(point.getX(), point.getY());
		switch (mode) {
		case FREE:
			_model.setDrawingShape(new MCOFree(point2));
			break;
		case RECT:
			_model.setDrawingShape(new MCORectangle(point2, point2));
			break;
		case OVAL:
			_model.setDrawingShape(new MCOOval(point2, point2));
			break;
		case TEXT:
			_model.setDrawingShape(new MCOText(point2, point2));
			break;
		default:
			break;
		}
		
		_model.setDrawingStartPoint(point2);
		_canvas.repaint();
	}
	@Override public void mouseReleased(MouseEvent e) {
		// add our new shape to the list
		if (_model.drawingShape() != null) {
			_model.drawingShape().initiate();
			_model.objects().add(_model.drawingShape());
		}
		
		// set focus if text box
		if (_model.drawingShape() instanceof MCOText) {
			_model.setFocusShape(_model.drawingShape());
			_canvas.requestFocusInWindow();
		}
		
		// release all current drawing resources
		_model.setDrawingStartPoint(null);
		_model.setDrawingCurrentPoint(null);
		_model.setDrawingShape(null);
		
		// call damage
		_canvas.repaint();
	}

	@Override public void keyTyped(KeyEvent e) {
		MCOText shape = (MCOText)_model.focusShape();
		if (shape == null) return;
		
		char key = e.getKeyChar();
		if (key == KeyEvent.CHAR_UNDEFINED) return;
		
		shape.addText(key);
		_canvas.repaint();
	}
	@Override public void keyPressed(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}
