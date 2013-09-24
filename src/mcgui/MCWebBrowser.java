package mcgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MCWebBrowser extends JPanel {
	private JTextField _textField = null;
	private JLabel _urlLabel = null;
	private JButton _backButton = null;
	private JButton _forwardButton = null;
	private JButton _goButton = null;
	private JEditorPane _editorPane = null;
	
	protected MCWebBrowser() {
		super(new BorderLayout(0, 0));
		
		// Panel for the URL bar
		JPanel urlBar = new JPanel(new BorderLayout(0, 0));
		_urlLabel = new JLabel("URL: ");
		urlBar.add(_urlLabel, BorderLayout.LINE_START);
		_textField = new JTextField("http://", 0);
		urlBar.add(_textField, BorderLayout.CENTER);
		
		// Button-level panel
		JPanel buttonBar = new JPanel();
		_backButton = new JButton("<");
		_goButton = new JButton("GO");
		_forwardButton = new JButton(">");
		buttonBar.add(_backButton);
		buttonBar.add(_goButton);
		buttonBar.add(_forwardButton);
		
		// Control Panel
		JPanel controls = new JPanel();
		controls.setLayout(new BoxLayout(controls, BoxLayout.PAGE_AXIS));
		controls.add(urlBar);
		controls.add(buttonBar);
		
		this.add(controls, BorderLayout.PAGE_START);
		
		// Display panel
		_editorPane = new JEditorPane();
		_editorPane.setEditable(false);
		_editorPane.setContentType("text/html");
		JScrollPane editorScrollPane = new JScrollPane(_editorPane);
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(250, 145));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		this.add(editorScrollPane, BorderLayout.CENTER);
		
		_goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = _textField.getText();
				java.net.URL URL = null;
				try {
					URL = new java.net.URL(url);
				} catch (MalformedURLException e2) {
					e2.printStackTrace();
				}
			    try {
			        _editorPane.setPage(URL);
			    } catch (IOException e3) {
			        System.err.println("Attempted to read a bad URL: " + URL);
			    }
			}
		});
	}
}
