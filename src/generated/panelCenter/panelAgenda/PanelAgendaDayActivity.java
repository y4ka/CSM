package generated.panelCenter.panelAgenda;

import javax.swing.JPanel;

import controller.dayEvents.DayEvent;
import controller.dayEvents.DayEvent.DAY_EVENTS;
import controller.dayEvents.EventMatch;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class PanelAgendaDayActivity extends JPanel
{
	private JLabel lblTeamA;
	private JLabel lblTeamB;
	private JLabel lblEventName;
	public PanelAgendaDayActivity() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		lblTeamA = new JLabel();
		add(lblTeamA, BorderLayout.WEST);
		
		lblEventName = new JLabel("Activity Name");
		lblEventName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblEventName, BorderLayout.CENTER);
		
		lblTeamB = new JLabel();
		add(lblTeamB, BorderLayout.EAST);
	}
	
	public void update(DayEvent dayEvent)
	{
		lblEventName.setText(dayEvent.getEventDescription());
		//this.setBackground(dayEvent.getEventColor());
		
		if (dayEvent.getEventType() == DAY_EVENTS.MATCH)
		{
			EventMatch match = (EventMatch) dayEvent;
			lblTeamA.setIcon(match.getTeamA().getImage());
			lblTeamB.setIcon(match.getTeamB().getImage());
		}
	}
}
