package app;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CRUDManagement extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnAddNewAirline, btnDeleteAirline, btnEditAirline, btnSelectAirline;

	/**
	 * Create the frame.
	 */
	public CRUDManagement() {
		setBounds(100, 100, 600, 450);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblDisplaying = new JLabel("Displaying All Airlines");
		lblDisplaying.setBounds(26, 28, 397, 25);
		add(lblDisplaying);
		
		ButtonListener addAirlineListener = new ButtonListener();
		ButtonListener deleteAirlineListener = new ButtonListener();
		ButtonListener editAirlineListener = new ButtonListener();
		ButtonListener selectAirlineListener = new ButtonListener();
		
		btnAddNewAirline = new JButton("Add Airline");
		btnAddNewAirline.setBounds(433, 149, 141, 23);
		btnAddNewAirline.addActionListener(addAirlineListener);
		add(btnAddNewAirline);
		
		btnDeleteAirline = new JButton("Delete Airline");
		btnDeleteAirline.setBounds(433, 220, 141, 23);
		btnDeleteAirline.setEnabled(false);
		btnDeleteAirline.addActionListener(deleteAirlineListener);
		add(btnDeleteAirline);
		
		btnEditAirline = new JButton("Edit Airline");
		btnEditAirline.setBounds(433, 183, 141, 23);
		btnEditAirline.setEnabled(false);
		btnEditAirline.addActionListener(editAirlineListener);
		add(btnEditAirline);
	
		btnSelectAirline = new JButton("Select Airline");
		btnSelectAirline.setBounds(433, 64, 141, 23);
		btnSelectAirline.setEnabled(false);
		btnSelectAirline.addActionListener(selectAirlineListener);
		add(btnSelectAirline);
		
		setOpaque(true);
		
		String[] columnNames = {"Airline Name"};

		Object[][] data = {
				{ "Bluh Airlines"},
				{ "Bleh Airlines"}
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
                btnDeleteAirline.setEnabled(true);
                btnEditAirline.setEnabled(true);
                btnSelectAirline.setEnabled(true);
            }
        }
        
        table.getSelectionModel().addListSelectionListener(new RowListener());
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddNewAirline){
				NewAirlinePopUp.createGUI();
			}
			if(e.getSource() == btnDeleteAirline) {
				//delete selected
				//update table
			}
			if(e.getSource() == btnEditAirline){
				//edit thing
				//update table
			}
			if(e.getSource() == btnSelectAirline){
				DisplayFlightsPerAirline.createGUI();
			}
		}
    }
}


