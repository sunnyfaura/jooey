package app;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class TicketCounter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	JLabel lblDisplaying;
	JButton btnAdvancedSearch, btnTotalSales, btnBuyTickets;
	
	static String ticketCounterName;
	
	public static void setTCName(String name){
		ticketCounterName = name;
	}
	
	/**
	 * Launch the application.
	 */
	public void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketCounter frame = new TicketCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	
	public TicketCounter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonListener searchListener = new ButtonListener();
		ButtonListener totalSalesListener = new ButtonListener();
		ButtonListener buyTicketsListener = new ButtonListener();
		
		lblDisplaying = new JLabel("Displaying Ticket Counter: " + ticketCounterName);
		lblDisplaying.setBounds(26, 28, 397, 25);
		contentPane.add(lblDisplaying);
		
		btnAdvancedSearch = new JButton("Search Flights");
		btnAdvancedSearch.setBounds(433, 72, 141, 23);
		btnAdvancedSearch.addActionListener(searchListener);
		contentPane.add(btnAdvancedSearch);
		
		btnTotalSales = new JButton("Show Total Sales");
		btnTotalSales.setBounds(433, 140, 141, 23);
		btnTotalSales.addActionListener(totalSalesListener);
		contentPane.add(btnTotalSales);
		
		btnBuyTickets = new JButton("Buy Tickets");
		btnBuyTickets.setBounds(433, 106, 141, 23);
		btnBuyTickets.addActionListener(buyTicketsListener);
		contentPane.add(btnBuyTickets);
		
		contentPane.setOpaque(true);
		
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
        contentPane.add(scrollPane);
        
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
