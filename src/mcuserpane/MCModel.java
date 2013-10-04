package mcuserpane;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class MCModel {
	private LinkedList<MCPage> _notebook;
	private int _index;
	
	public MCModel() {
		_notebook = new LinkedList<>();
		_notebook.add(new MCPage());
		_index = 0;
	}
	
	public void deletePage() {
		_notebook.remove(_index);
		if (_notebook.size() == 0)
			_notebook.add(new MCPage());
		if (_index >= _notebook.size())
			_index = _notebook.size() - 1;
	}
	
	public void newPage() {
		_notebook.add(_index, new MCPage());
	}
	
	public void forward() {
		++_index;
		if (_index >= _notebook.size())
			_index = _notebook.size() - 1;
	}
	
	public void back() {
		--_index;
		if (_index < 0)
			_index = 0;
	}
	
	public int currentPageNumber() { return _index; }
	public MCObject focusShape() { return _notebook.get(_index)._focusShape; }
	public void setFocusShape(MCObject shape) { _notebook.get(_index)._focusShape = shape; }
	public Point2D.Double drawingStartPoint() { return _notebook.get(_index)._drawingStartPoint; }
	public void setDrawingStartPoint(Point2D.Double point) { _notebook.get(_index)._drawingStartPoint = point; }
	public Point2D.Double drawingCurrentPoint() { return _notebook.get(_index)._drawingCurrentPoint; }
	public void setDrawingCurrentPoint(Point2D.Double point) { _notebook.get(_index)._drawingCurrentPoint = point; }
	public MCObject drawingShape() { return _notebook.get(_index)._drawingShape; }
	public void setDrawingShape(MCObject shape) { _notebook.get(_index)._drawingShape = shape; }
	public ArrayList<MCObject> objects() { return _notebook.get(_index)._objects; }
}
