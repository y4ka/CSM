package generated.MainPanels;

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
	private JLabel lblActivityIcon1;
	private JLabel lblActivity1;
	private JLabel lblActivityIcon2;
	private JLabel lblActivity2;
	private JLabel lblActivityIcon3;
	private JLabel lblActivity3;

	/**
	 * Create the panel.
	 */
	public PanelAgendaDay() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "day", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelAgendaDayActivity1 = new JPanel();
		panelAgendaDayActivity1.setBackground(Color.LIGHT_GRAY);
		add(panelAgendaDayActivity1);
		panelAgendaDayActivity1.setLayout(new BorderLayout(0, 0));
		
		lblActivityIcon1 = new JLabel("Icon");
		panelAgendaDayActivity1.add(lblActivityIcon1, BorderLayout.WEST);
		
		lblActivity1 = new JLabel("ActivityName");
		panelAgendaDayActivity1.add(lblActivity1);
		
		JPanel panelAgendaDayActivity2 = new JPanel();
		panelAgendaDayActivity2.setBackground(Color.LIGHT_GRAY);
		add(panelAgendaDayActivity2);
		panelAgendaDayActivity2.setLayout(new BorderLayout(0, 0));
		
		lblActivityIcon2 = new JLabel("Icon");
		panelAgendaDayActivity2.add(lblActivityIcon2, BorderLayout.WEST);
		
		lblActivity2 = new JLabel("ActivityName");
		panelAgendaDayActivity2.add(lblActivity2);
		
		JPanel panelAgendaDayActivity3 = new JPanel();
		panelAgendaDayActivity3.setBackground(Color.LIGHT_GRAY);
		add(panelAgendaDayActivity3);
		panelAgendaDayActivity3.setLayout(new BorderLayout(0, 0));
		
		lblActivityIcon3 = new JLabel("Icon");
		panelAgendaDayActivity3.add(lblActivityIcon3, BorderLayout.WEST);
		
		lblActivity3 = new JLabel("ActivityName");
		panelAgendaDayActivity3.add(lblActivity3);

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
