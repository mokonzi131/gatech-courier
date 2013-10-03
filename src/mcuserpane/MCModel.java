package mcuserpane;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MCModel {
	protected ArrayList<MCObject> _objects;
	
	protected Point2D.Double _drawingStartPoint;
	protected Point2D.Double _drawingCurrentPoint;
	protected MCObject _drawingShape;
	
	public MCModel() {
		_objects = new ArrayList<>();
		
		_drawingStartPoint = null;
		_drawingCurrentPoint = null;
		_drawingShape = null;
	}
	
	public int currentPageNumber() { return 0; }
}
