package mcuserpane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public abstract class MCObject {
	public Color _color = Color.GREEN;
	public abstract void update(Point2D.Double point);
	public abstract void render(Graphics2D g);
	public abstract void create();
}
