package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelMessagerieDetailActions extends JPanel {
	private JButton btnAccepter;
	private JButton btnRefuser;

	/**
	 * Create the panel.
	 */
	public PanelMessagerieDetailActions() {
		
		btnAccepter = new JButton("Accepter");
		add(btnAccepter);
		
		btnRefuser = new JButton("Refuser");
		add(btnRefuser);

	}

	public JButton getBtnRefuser() {
		return btnRefuser;
	}
	public JButton getBtnAccepter() {
		return btnAccepter;
	}
}
