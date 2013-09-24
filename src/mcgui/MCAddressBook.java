package mcgui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import addressbook.Address;

import mcdata.MCDataMaster;

@SuppressWarnings("serial")
public class MCAddressBook extends JPanel {	
	private static String[] columnNames = {"NAME", "ADDRESS", "PHONE NUMBER", "NOTES"};
	private List<Address> _addresses;
	
	private JTable _table = null;
	private JTextArea _formal = null;
	
	private int _index = 0;
	
	public MCAddressBook() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		_addresses = MCDataMaster.getInstance().addresses();
		
		Object[][] data = new Object[_addresses.size()][4];
		for(int i = 0; i < _addresses.size(); ++i) {
			data[i][0] = _addresses.get(i).name();
			data[i][1] = _addresses.get(i).address();
			data[i][2] = _addresses.get(i).number().toString();
			data[i][3] = _addresses.get(i).note();
		}
		_table = new JTable(data, columnNames);
		_table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		_table.setFillsViewportHeight(true);
		
		JScrollPane tablePane = new JScrollPane(_table);
		this.add(tablePane);
		
		_formal = new JTextArea();
		_formal.setText(_addresses.get(_index).pretty());
		this.add(_formal);
		
		// listener
		_table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = _table.rowAtPoint(evt.getPoint());
		        if (row >= 0) {
		        	_index = row;
		        	_formal.setText(_addresses.get(_index).pretty());
		        	_formal.repaint();
		        }
		    }
		});
	}
}
