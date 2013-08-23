package mcgui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class MockCourierWindow implements Runnable {
	private JSplitPane _splitPane = null;
	private JLabel _statusBar = null;
	private AppPane _appPane = null;
	private UserPane _userPane = null;
	
	// this is the thread-safe entry to the Swing Creation methods
	@Override
	public void run() {
		_appPane = new AppPane();
		_userPane = new UserPane();
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
		_userPane.initialize();
		
		// status bar
		_statusBar = new JLabel("THIS IS THE STATUS OF THE APPLICATION...");
		_statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
		
		frame.getContentPane().add(_splitPane, BorderLayout.CENTER);
		frame.getContentPane().add(_statusBar, BorderLayout.PAGE_END);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
