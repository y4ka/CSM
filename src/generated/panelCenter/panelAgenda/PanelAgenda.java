package generated.panelCenter.panelAgenda;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.Day;
import modele.Agenda;
import modele.GameData;
import modele.Observer;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.GridLayout;

public class PanelAgenda extends JPanel implements Observer {
	
	ArrayList<PanelAgendaDay> panelAgendaDayList = new ArrayList<PanelAgendaDay>();
	final int MAXIMUM_NUMBER_OF_DAYS = 31;
	
	/**
	 * Create the panel.
	 */
	public PanelAgenda() {
		setBorder(new TitledBorder(null, "Agenda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 7, 0, 0));
		
		//On crée 31 panels de journée:
		for (int i = 0 ; i < MAXIMUM_NUMBER_OF_DAYS ; i++)
		{
			PanelAgendaDay panelAgendaDay = new PanelAgendaDay();
			this.add(panelAgendaDay);
			panelAgendaDayList.add(panelAgendaDay);
		}
	}

	@Override
	public void update(GameData gameData) 
	{	
		Agenda agenda = gameData.getAgenda();
		final LocalDate currentDate = agenda.getCurrentDate();
		
		//On met a jour le titre avec le mois en cours:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle("Agenda - "+currentDate.getMonth());
		
		int numberOfDays = currentDate.lengthOfMonth();
		for (int i = 0 ; i < MAXIMUM_NUMBER_OF_DAYS ; i++)
		{
			//On récupère les panelAgendaDay:
			PanelAgendaDay panelAgendaDay = panelAgendaDayList.get(i);
			
			int dayValue = i+1;
			if (dayValue <= numberOfDays)
			{
				//On les mets à jour:
				LocalDate date = currentDate.withDayOfMonth(dayValue);
				Day day = agenda.getDay(date);
				boolean isCurrentDate = agenda.isCurrentDate(date);
				
				panelAgendaDay.update(date, day, isCurrentDate);
				panelAgendaDay.setVisible(true);
			}
			else
			{
				//Panels en trop pour le nombre de jours du mois:
				panelAgendaDay.setVisible(false);
			}
			
		}
	}
}
