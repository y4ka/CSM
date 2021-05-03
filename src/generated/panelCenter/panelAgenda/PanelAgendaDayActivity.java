package generated.panelCenter.panelAgenda;

import javax.swing.JPanel;

import controller.dayEvents.DayEvent;
import controller.dayEvents.DayEvent.DAY_EVENTS;
import controller.dayEvents.EventMatch;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class PanelAgendaDayActivity extends JPanel
{
	private JLabel lblTeamA;
	private JLabel lblTeamB;
	private JLabel lblEventName;
	public PanelAgendaDayActivity() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		lblTeamA = new JLabel();
		add(lblTeamA);
		
		lblEventName = new JLabel("Activity Name");
		add(lblEventName);
		
		lblTeamB = new JLabel();
		add(lblTeamB);
	}
	
	public void update(DayEvent dayEvent)
	{
		lblEventName.setText(dayEvent.getEventDescription());
		this.setBackground(dayEvent.getEventColor());
		
		if (dayEvent.getEventType() == DAY_EVENTS.MATCH)
		{
			EventMatch match = (EventMatch) dayEvent;
			lblTeamA.setIcon(match.getTeamA().getImage());
			lblTeamB.setIcon(match.getTeamB().getImage());
		}
	}
}
