package mcuserpane;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class MCUserPane extends JPanel {
	private MCCanvas _canvas = null;
	
	public MCUserPane() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// setup the canvas
		_canvas = new MCCanvas();
		this.setVisible(true);
		this.add(_canvas);
		
		// setup the page controls
		JPanel pageControls = new JPanel();
		pageControls.add(new JButton("New Page"));
		pageControls.add(new JButton("Delete Page"));
		pageControls.add(new JButton("Page Forward"));
		pageControls.add(new JButton("Page Backward"));
		this.add(pageControls);
		
		// setup the canvas controls
		JPanel canvasControls = new JPanel();
		JRadioButton free = new JRadioButton("Free Form Ink");
		JRadioButton rect = new JRadioButton("Rectangle");
		JRadioButton oval = new JRadioButton("Oval");
		JRadioButton text = new JRadioButton("Text");
		
		free.setSelected(true);
		
		ButtonGroup selectionGroup = new ButtonGroup();
		selectionGroup.add(free);
		selectionGroup.add(rect);
		selectionGroup.add(oval);
		selectionGroup.add(text);
		
		canvasControls.add(free);
		canvasControls.add(rect);
		canvasControls.add(oval);
		canvasControls.add(text);
		
		this.add(canvasControls);
	}
}
