package app;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class TicketCounter  extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	JLabel lblDisplaying;
	JButton btnAdvancedSearch, btnTotalSales, btnBuyTickets;

	/**
	 * Create the frame.
	 */
	public TicketCounter() {
		setBounds(100, 100, 600, 450);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		ButtonListener searchListener = new ButtonListener();
		ButtonListener totalSalesListener = new ButtonListener();
		ButtonListener buyTicketsListener = new ButtonListener();
		
		lblDisplaying = new JLabel("Displaying someNumber of Flights");
		lblDisplaying.setBounds(26, 28, 397, 25);
		add(lblDisplaying);
		
		btnAdvancedSearch = new JButton("Search Flights");
		btnAdvancedSearch.setBounds(433, 72, 141, 23);
		btnAdvancedSearch.addActionListener(searchListener);
		add(btnAdvancedSearch);
		
		btnTotalSales = new JButton("Show Total Sales");
		btnTotalSales.setBounds(433, 140, 141, 23);
		btnTotalSales.addActionListener(totalSalesListener);
		add(btnTotalSales);
		
		btnBuyTickets = new JButton("Buy Tickets");
		btnBuyTickets.setBounds(433, 106, 141, 23);
		btnBuyTickets.addActionListener(buyTicketsListener);
		add(btnBuyTickets);
		
		setOpaque(true);
		
		String[] columnNames = {"Flight Name", "Date"};

		Object[][] data = {
				{ "ADFADS321" , "12-2-2013"},
				{ "SFSDFF878", "3-24-2013"}
		};
		
		table = new JTable(data, columnNames){
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(26, 64, 397, 292);
        add(scrollPane);
        
        class RowListener implements ListSelectionListener {
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }
                //do stuff
            }
        }
        
        table.getSelectionModel().addListSelectionListener(new RowListener());
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAdvancedSearch){
				SearchCriteriaForFlight.createGUI();
			}
			if(e.getSource() == btnTotalSales) {
				TicketCounterTotalSales.createGUI();
			}
			if(e.getSource() == btnBuyTickets){
				BuyTickets.createGUI();
			}
		}
    }
}
