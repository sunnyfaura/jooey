package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import app.entity.Airline;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class AllAirlines extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private AirlineTableModel dm;
	/**
	 * Create the panel.
	 */
	public AllAirlines() {
		setBounds(100, 100, 200, 600);		 
		setLayout(null);
		
		setOpaque(true);
		dm = new AirlineTableModel();
		
		table = new JTable(dm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 200, 471 );
        add(scrollPane);
        
        JButton btnAddNewAirline = new JButton("Add New Airline");
        btnAddNewAirline.setBounds(22, 482, 155, 23);
        add(btnAddNewAirline);
        
        JButton btnAddNewFlights = new JButton("Add New Flights");
        btnAddNewFlights.setBounds(22, 507, 155, 23);
        add(btnAddNewFlights);
        
        JButton btnEditAirline = new JButton("Edit Airline");
        btnEditAirline.setBounds(22, 532, 155, 23);
        add(btnEditAirline);
        
        JButton btnDeleteAirline = new JButton("Delete Airline");
        btnDeleteAirline.setBounds(22, 566, 155, 23);
        add(btnDeleteAirline);
	}
	
	public void updateData(List<Airline> m){
		for(Airline a : m){
			dm.addElement(a);
		}
	}
}

class AirlineTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] columnNames = {"Airline Name"};
    private final LinkedList<Airline> list;

    public AirlineTableModel() {
        list = new LinkedList<Airline>();
    }

    public void addElement(Airline e) {
        // Adds the element in the last position in the list
        list.add(e);
        fireTableRowsInserted(list.size()-1, list.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getName();
            case 1: return list.get(rowIndex).getName();
        }
        return null;
    }
}
