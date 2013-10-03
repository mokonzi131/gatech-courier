package mcgui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import mcuserpane.MCUserPane;

public class MockCourierWindow implements Runnable {
	// singleton access pattern to application
	private static volatile MockCourierWindow _instance = null;
	private MockCourierWindow() {}
	public static MockCourierWindow getInstance() {
		if (_instance == null) {
			synchronized (MockCourierWindow.class) {
				if (_instance == null) {
					_instance = new MockCourierWindow();
				}
			}
		}
		return _instance;
	}
	
	// instance variables
	private JSplitPane _splitPane = null;
	private JLabel _statusBar = null;
	private MCAppPane _appPane = null;
	private MCUserPane _userPane = null;
	
	// this is the thread-safe entry to the Swing Creation methods
	@Override
	public void run() {
		_appPane = new MCAppPane();
		_userPane = new MCUserPane();
		initialize();
	}
	
	private void initialize() {
		JFrame frame = new JFrame("GaTech : Michael Landes : Mock Courier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout(0, 0));
		
		// main content in split pane
		_splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, _appPane, _userPane);
		_splitPane.setResizeWeight(0.5);
		_appPane.initialize();
		
		// status bar
		_statusBar = new JLabel("THIS IS THE STATUS OF THE APPLICATION...");
		_statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
		
		frame.getContentPane().add(_splitPane, BorderLayout.CENTER);
		frame.getContentPane().add(_statusBar, BorderLayout.PAGE_END);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setStatus(String message) {
		_statusBar.setText(message);
	}
}
