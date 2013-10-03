package mcuserpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MCCanvasControls extends JPanel implements ActionListener {
	private MODE _currentMode;
	
	protected enum MODE {
		FREE,
		RECT,
		OVAL,
		TEXT
	}
	protected MODE currentMode() { return _currentMode; }
	
	private ButtonGroup _selectionGroup;
	private JRadioButton _free, _rect, _oval, _text;
	
	public MCCanvasControls() {		
		_free = new JRadioButton("Free Form Ink");
		_rect = new JRadioButton("Rectangle");
		_oval = new JRadioButton("Oval");
		_text = new JRadioButton("Text");
		_free.setSelected(true);
		
		_selectionGroup = new ButtonGroup();
		_selectionGroup.add(_free);
		_selectionGroup.add(_rect);
		_selectionGroup.add(_oval);
		_selectionGroup.add(_text);
		
		this.add(_free);
		this.add(_rect);
		this.add(_oval);
		this.add(_text);
		
		_free.addActionListener(this);
		_rect.addActionListener(this);
		_oval.addActionListener(this);
		_text.addActionListener(this);
		
		_currentMode = MODE.FREE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == _free && _free.isSelected())
			_currentMode = MODE.FREE;
		else if (source == _rect && _rect.isSelected())
			_currentMode = MODE.RECT;
		else if (source == _oval && _oval.isSelected())
			_currentMode = MODE.OVAL;
		else if (source == _text && _text.isSelected())
			_currentMode = MODE.TEXT;
	}
}
