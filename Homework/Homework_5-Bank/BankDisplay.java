import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BankDisplay extends JFrame{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelCenter,
	panelSouth;
	
	private JLabel queueLabel; // JPanel for Label
	private Set<TellerPanel> setPanelTeller; // set for JPanel for Teller with Button
	
	private Set<Teller> setTeller;
	
	private Set<JPanel> setPanel;
	
	private FlowLayout fL;
	private Bank bk;
	
	
	public BankDisplay(Bank bk) {
		this.bk = bk;
		setTeller = bk.getTellers();
		setPanel = new HashSet<JPanel>();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		
		this.setPanelTeller = new HashSet<TellerPanel>();
		
		
		for(Teller t : this.setTeller) { // Create all the JPanel that need for Tellers.
			TellerPanel p = new TellerPanel(t);
			setPanel.add(p);	
			this.setPanelTeller.add(p);	
		}
		for(TellerPanel j : setPanelTeller) {
			panelCenter.add(j);
		}
		
		queueLabel = new JLabel(this.bk.getCustomersQueue().toString());
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
		

		
		Dimension westAndEast = new Dimension(50, 40);

		panelSouth.setPreferredSize(westAndEast);
		
		this.setTitle("Bank Simulation");
		this.setLayout(new BorderLayout());
		this.add(panelCenter,BorderLayout.CENTER);
		this.add(panelSouth,BorderLayout.SOUTH);
		
		panelSouth.setBorder(BorderFactory.createLineBorder(Color.black,5));
		panelSouth.add(queueLabel);
		
		
		this.setSize(new Dimension(500,450));
		this.setVisible(true);

	}
	
	public void refresh() {
		for(TellerPanel j : setPanelTeller) {
			j.panelRefresh();
		}
		this.queueLabel.setText(this.bk.getCustomersQueue().toString());
		
	}

	
	public void close()
	{
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}


}