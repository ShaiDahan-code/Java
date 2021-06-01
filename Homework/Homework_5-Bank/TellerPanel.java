import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TellerPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teller t;
	private JButton idle_button;
	private JLabel teller_label;
	private FlowLayout fL;
	
	public TellerPanel(Teller t) {
		this.t = t;
		this.setPreferredSize(new Dimension(400,40));
		this.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		fL = new FlowLayout(FlowLayout.LEFT);
		
		this.idle_button = new JButton("Idle");
		this.idle_button.addActionListener(this);
		
		this.teller_label = new JLabel("");

		this.setLayout(fL);
		this.add(idle_button);
		this.add(teller_label);
		
	}
	
	public void panelRefresh() {
		StringBuffer sb = new StringBuffer();
		sb.append("Sample: Teller " + this.t.getTellerNumber() + " is ");
		if (t.isIdle())
			sb.append("idle");
		else {
			sb.append("active");
			if (t.isServing())
				sb.append(", currently serving customer " + t.getCustNumber());
		}
		this.teller_label.setText(sb.toString());
		if(!this.t.GoIdle())
			this.idle_button.setEnabled(true);
	}
	public Teller getT() {
		return t;
	}

	public void setT(Teller t) {
		this.t = t;
	}

	public JButton getIdle_button() {
		return idle_button;
	}

	public JLabel getTeller_labelText() {
		return teller_label;
	}

	public void setTeller_label(JLabel teller_label) {
		this.teller_label = teller_label;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getSource() == idle_button) {
			this.idle_button.setEnabled(false);
			this.t.setGoIdle(true);
		}
		
	}


}
