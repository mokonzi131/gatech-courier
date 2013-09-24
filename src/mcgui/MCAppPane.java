package mcgui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MCAppPane extends JPanel {
	private JTabbedPane _tabbedPane = null;
	
	private MCWebBrowser _browser = null;
	private MCAddressBook _book = null;
	
	public void initialize() {
		// create contents
		_browser = new MCWebBrowser();
		_book = new MCAddressBook();
		
		// create the tabbed pane
		_tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		
		// add everything together
		_tabbedPane.addTab("Mock Courier Browser", _browser);
		_tabbedPane.addTab("MC Address Book", _book);
		this.add(_tabbedPane);
	}
}
