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
import javax.swing.BoxLayout;

public class PanelAgendaDay extends JPanel {
	private JLabel lblActivityName;
	private JPanel panelAgendaDayActivity;

	/**
	 * Create the panel.
	 */
	public PanelAgendaDay() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "day", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		panelAgendaDayActivity = new JPanel();
		panelAgendaDayActivity.setBackground(Color.LIGHT_GRAY);
		add(panelAgendaDayActivity, BorderLayout.NORTH);
		panelAgendaDayActivity.setLayout(new BorderLayout(0, 0));
		
		lblActivityName = new JLabel("ActivityName");
		panelAgendaDayActivity.add(lblActivityName);

	}

	public void update(LocalDate date, Day day, boolean isCurrentDate)
	{
		DayEvent dayEvent = day.getDayEvent();
		
		//On met à jour les activités du jour:
		if (dayEvent != null)
		{
			String eventDescription = dayEvent.getEventDescription();
			lblActivityName.setText(eventDescription);
			panelAgendaDayActivity.setBackground(dayEvent.getEventColor());
		}
		else
		{
			lblActivityName.setText("PAS D'ACTIVITE");
		}
		
		//On met a jour le titre avec la date:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(""+date.getDayOfMonth());
		
		//On met à jour la couleur du jour courant:
		if (isCurrentDate)
		{
			this.setBackground(Color.LIGHT_GRAY);
			titledBorder.setTitleColor(Color.RED);
		}
		else
		{
			titledBorder.setTitleColor(Color.BLACK);
			this.setBackground(UIManager.getColor ("Panel.background"));
		}
	}
}
