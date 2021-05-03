package generated.panelCenter.panelAgenda;

import javax.swing.JPanel;

import controller.dayEvents.DayEvent;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class PanelAgendaDayActivity extends JPanel
{
	private JLabel lblEventName;
	public PanelAgendaDayActivity() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblEventName = new JLabel("Activity Name");
		add(lblEventName);
	}
	
	public void update(DayEvent dayEvent)
	{
		lblEventName.setText(dayEvent.getEventDescription()+" "+dayEvent.getEventStatus());
		this.setBackground(dayEvent.getEventColor());
	}
}
