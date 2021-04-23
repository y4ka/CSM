package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.DayEvent.EVENT_STATUS;
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
		// Match présenté mais pas commencé:
		if (match.getEventStatus() == EVENT_STATUS.BRIEFED)
		{
			btnStart.setText("Start match");
			btnStart.setEnabled(true);
		}
		
		// Match présenté, commencé mais pas terminé:
		if (match.getEventStatus() == EVENT_STATUS.STARTED)
		{
			btnStart.setText("Play Round");
			btnStart.setEnabled(true);
		}
		
		// Match terminé:
		if (match.getEventStatus() == EVENT_STATUS.ENDED)
		{
			btnStart.setText("Match over");
			btnStart.setEnabled(false);
		}
	}
}
