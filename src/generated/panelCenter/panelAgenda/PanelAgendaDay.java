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
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class PanelAgendaDay extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAgendaDay() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "day", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));

	}

	public void update(LocalDate date, Day day, boolean isCurrentDate)
	{
		//test
		this.removeAll();
		
		//On met à jour les activités du jour:
		ArrayList<DayEvent> dayEvents = day.getDayEvents();
		for(DayEvent dayEvent : dayEvents)
		{
			PanelAgendaDayActivity panelAgendaDayActivity = new PanelAgendaDayActivity();
			panelAgendaDayActivity.update(dayEvent);
			this.add(panelAgendaDayActivity);
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
