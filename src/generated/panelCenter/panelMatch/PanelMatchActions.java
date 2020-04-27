package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;

import javax.swing.JButton;

public class PanelMatchActions extends JPanel {
	private JButton btnStart;

	/**
	 * Create the panel.
	 */
	public PanelMatchActions() {
		setBorder(new TitledBorder(null, "Actions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnStart = new JButton("Start");
		add(btnStart);

	}

	public JButton getBtnStart() {
		return btnStart;
	}
	
	public void update(EventMatch match)
	{
		if (match.isFinished())
		{
			btnStart.setText("Match over");
			btnStart.setEnabled(false);
		}
	}
}
