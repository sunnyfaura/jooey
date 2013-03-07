package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainInCardLayout implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel cards;
	final static String CRUDPANEL = "Airline/Ticket CRUD Management";
    final static String TCPANEL = "Ticket Counter";
	
	/**
	 * Create the panel.
	 */
	public void createCards(Container pane){
		JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { CRUDPANEL, TCPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
		
        cards = new JPanel(new CardLayout());
		CRUDManagement paneCRUD = new CRUDManagement();
		TicketCounter paneTC = new TicketCounter();
		
		cards.add(paneCRUD, CRUDPANEL);
		cards.add(paneTC, TCPANEL);
		pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
	}
}
