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
		switch (match.getEventStatus())
		{
		case NOT_STARTED:
		case BRIEFING:
			btnStart.setText("Start match");
			btnStart.setEnabled(true);
			break;
		case STARTED:
			btnStart.setText("Play Round");
			btnStart.setEnabled(true);
			break;
		case DEBRIEFING:
		case ENDED:
			btnStart.setText("Match over");
			btnStart.setEnabled(false);
			break;
		}
	}
}
