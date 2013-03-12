package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;

import app.entity.Airline;
import app.entity.Flight;

public class TicketCounters extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private static FlightTableModel dm;
	/**
	 * Create the panel.
	 */
	public TicketCounters() {
		setBounds(100, 100, 600, 700);
		setLayout(null);
		
		setOpaque(true);
		dm = new FlightTableModel();
		
		table = new JTable(dm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 585, 700);
        add(scrollPane);
	}
	
	public static void updateData(List<Flight> m){
		for(Flight a : m){
			dm.addElement(a);
		}
	}
	
}

class FlightTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] columnNames = {"Flight Name", "Date", "First-Class Fare", "Economy Fare", "Available(FC)", "Available(E)"};
    private final LinkedList<Flight> list;

    public FlightTableModel() {
        list = new LinkedList<Flight>();
    }

    public void addElement(Flight e) {
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
            case 1: return list.get(rowIndex).getDate();
            case 2: return list.get(rowIndex).getFirstClassFare();
            case 3: return list.get(rowIndex).getEconomyFare();
            case 4: return list.get(rowIndex).getAvailableFirstClass();
            case 5: return list.get(rowIndex).getAvailableEconomy();
        }
        return null;
    }
}
