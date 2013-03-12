package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import app.entity.Airline;
import app.entity.Flight;
import app.repositories.AirlineRepository;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;

public class AllAirlines extends JPanel {
	
	@Autowired
	private AirlineRepository airlineDao;
	
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
		setBounds(100, 100, 200, 700);		 
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
        btnAddNewAirline.setBounds(22, 524, 155, 23);
        add(btnAddNewAirline);
        
        JButton btnAddNewFlights = new JButton("Add New Flights");
        btnAddNewFlights.setBounds(22, 546, 155, 23);
        add(btnAddNewFlights);
        
        JButton btnEditAirline = new JButton("Edit Airline");
        btnEditAirline.setBounds(22, 569, 155, 23);
        add(btnEditAirline);
        
        JButton btnDeleteAirline = new JButton("Delete Airline");
        btnDeleteAirline.setBounds(22, 591, 155, 23);
        add(btnDeleteAirline);
        
        JButton btnShowAllFlights = new JButton("Show All Flights");
        btnShowAllFlights.setBounds(22, 490, 155, 23);
        add(btnShowAllFlights);
	}
	
	public void updateData(List<Airline> m){
		for(Airline a : m){
			dm.addElement(a);
		}
	}

	public String getAirlineName(){
		int row = table.getSelectedRow();
		String name = (String) table.getValueAt(row,0);
		System.out.println(name);
		return name;
	}
	
	public JTable getTable(){
		return table;
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
        }
        return null;
    }
}