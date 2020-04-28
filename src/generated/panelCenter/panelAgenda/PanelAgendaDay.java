package generated.panelCenter.panelAgenda;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.Day;
import controller.dayEvents.DayEvent;
import modele.GameData;
import modele.Observer;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.awt.BorderLayout;

public class PanelAgendaDay extends JPanel {
	private JLabel lblActivity1;

	/**
	 * Create the panel.
	 */
	public PanelAgendaDay() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "day", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelAgendaDayActivity = new JPanel();
		panelAgendaDayActivity.setBackground(Color.LIGHT_GRAY);
		add(panelAgendaDayActivity);
		panelAgendaDayActivity.setLayout(new BorderLayout(0, 0));
		
		lblActivity1 = new JLabel("ActivityName");
		panelAgendaDayActivity.add(lblActivity1);

	}

	public void update(LocalDate date, Day day, boolean isCurrentDate)
	{
		DayEvent dayEvent = day.getDayEvent();
		
		//On met à jour les activités du jour:
		if (dayEvent != null)
		{
			String eventDescription = dayEvent.getEventDescription();
			lblActivity1.setText(eventDescription);
		}
		else
		{
			lblActivity1.setText("PAS D'ACTIVITE");
		}
		
		//On met à jour la couleur du jour courant:
		if (isCurrentDate)
		{
			this.setBackground(Color.RED);
		}
		
		//On met a jour le titre avec la date:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(""+date.getDayOfMonth());
	}
}
