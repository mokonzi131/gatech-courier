package mcuserpane;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MCPage {
	protected ArrayList<MCObject> _objects;
	
	protected Point2D.Double _drawingStartPoint;
	protected Point2D.Double _drawingCurrentPoint;
	protected MCObject _drawingShape;
	
	protected MCObject _focusShape;
	
	public MCPage() {
		_objects = new ArrayList<>();
		
		_drawingStartPoint = null;
		_drawingCurrentPoint = null;
		_drawingShape = null;
		
		_focusShape = null;
	}
}
