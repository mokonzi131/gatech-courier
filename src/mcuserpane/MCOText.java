package mcuserpane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class MCOText extends MCObject {
	private static Color pastels[] = {
		new Color(166, 188, 241),
		new Color(166, 241, 181),
		new Color(241, 166, 188),
		new Color(219, 166, 241)
	};
	
	private Point2D.Double _p1;
	private Point2D.Double _p2;
	
	public MCOText(Point2D.Double p1, Point2D.Double p2) {
		_color = pastels[(int)(Math.random() * (pastels.length - 1))];
		_p1 = p1;
		_p2 = p2;
	}

	@Override
	public void update(Double point) {
		_p2 = point;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(_color);
		int x = (int) Math.min(_p1.x, _p2.x);
		int y = (int) Math.min(_p1.y, _p2.y);
		int width = (int) Math.abs(_p2.x - _p1.x);
		int height = (int) Math.abs(_p2.y - _p1.y);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
	}
}
