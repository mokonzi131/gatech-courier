package mcuserpane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import mcgui.MockCourierWindow;

public class MCOText extends MCObject {
	private static Color pastels[] = {
		new Color(166, 188, 241),
		new Color(166, 241, 181),
		new Color(241, 166, 188),
		new Color(219, 166, 241)
	};
	private static Color _shadow =
			new Color(110, 110, 110, 150);
	
	private Point2D.Double _p1;
	private Point2D.Double _p2;
	protected String _message;
	private Font _font;
	
	public MCOText(Point2D.Double p1, Point2D.Double p2) {
		_color = pastels[(int)(Math.random() * (pastels.length - 1))];
		_p1 = p1;
		_p2 = p2;
		_message = new String();
		_font = new Font("Dialog", Font.BOLD, 20);
	}

	@Override
	public void update(Double point) {
		_p2 = point;
	}
	
	final int PADDING = 20;
	private String nextLine(final int index, final double limit, final FontRenderContext context) {
		if (_message.substring(index).length() == 0) return "";
		
		int pointer = index + 1;
		
		// find the boundary (by moving past it)
		for (; pointer < _message.length(); ++pointer) {
			Rectangle2D rectangle = _font.getStringBounds(_message, index, pointer, context);
			if (rectangle.getWidth() + PADDING > limit)
				break;
		}

		return _message.substring(index, pointer);
	}
	
	private List<String> getLines(FontRenderContext context) {
		List<String> lines = new ArrayList<>();
		
		int index = 0;
		final double limit = Math.abs(_p2.x - _p1.x);
		
		// while there is another line, add it to the list
		String line = nextLine(index, limit, context);
		while (line.length() > 0) {
			lines.add(line);
			index += line.length();
			line = nextLine(index, limit, context);
		}

		return lines;
	}

	@Override
	public void render(Graphics2D g) {
		// break message into lines
		List<String> lines = getLines(g.getFontRenderContext());
		
		// gather the needed measurements
		FontMetrics metrics = g.getFontMetrics(_font);
		int lineHeight = metrics.getHeight();
		int verticalOffset = metrics.getAscent();
		
		// increase object height if necessary
		double span = lines.size() * lineHeight;
		if (span > Math.abs(_p2.y - _p1.y))
			_p2 = new Point2D.Double(_p2.x, _p1.y + span);
		
		// render the post-it note		
		int x = (int) Math.min(_p1.x, _p2.x);
		int y = (int) Math.min(_p1.y, _p2.y);
		int width = (int) Math.abs(_p2.x - _p1.x);
		int height = (int) Math.abs(_p2.y - _p1.y);
		g.setColor(_shadow);
		g.fillRect(x-4, y+3, width, height);
		g.setColor(_color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		
		// render the font
		g.setFont(_font);
		for (int i = 0; i < lines.size(); ++i) {
			String line = lines.get(i);
			g.drawChars(line.toCharArray(), 0, line.length(), x, y + (i * lineHeight) + verticalOffset);
		}
	}

	@Override
	public void initiate() {
		double x1 = Math.min(_p1.x, _p2.x);
		double y1 = Math.min(_p1.y, _p2.y);
		double x2 = x1 + Math.abs(_p2.x - _p1.x);
		double y2 = y1 + Math.abs(_p2.y - _p1.y);
		_p1 = new Point2D.Double(x1, y1);
		_p2 = new Point2D.Double(x2, y2);
	}
	
	public void addText(char text) {
		MockCourierWindow.getInstance().setStatus("KEY: "+text);
		_message += text;
	}
}
