package mcuserpane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

public class MCOFree extends MCObject {
	private ArrayList<Point2D.Double> _points;
	
	public MCOFree(Point2D.Double initial) {
		_points = new ArrayList<>();
		_points.add(initial);
	}

	@Override
	public void update(Double point) {
		_points.add(point);
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(_color);
		for (int i = 1; i < _points.size(); ++i)
			g.drawLine(
					(int)_points.get(i-1).x,
					(int)_points.get(i-1).y,
					(int)_points.get(i).x,
					(int)_points.get(i).y);
	}

	@Override
	public void create() {
		_color = Color.RED;
	}
}
