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
	
	/**
	 * Create the panel.
	 */
	public PanelAgenda() {
		setBorder(new TitledBorder(null, "Agenda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 7, 0, 0));
	}

	public void update(GameData gameData) 
	{	
		Agenda agenda = gameData.getAgenda();
		final LocalDate currentDate = agenda.getCurrentDate();
		
		//On met a jour le titre avec le mois en cours:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle("Agenda - "+currentDate.getMonth());
		
		//On supprime les PanelAgendaDay d�j� pr�sents:
		this.removeAll();
		
		//On cr�e les PanelAgendaDay:
		int numberOfDays = currentDate.lengthOfMonth();
		for (int i = 1 ; i <= numberOfDays ; i++)
		{
			//On cr�e les panelAgendaDay:
			PanelAgendaDay panelAgendaDay = new PanelAgendaDay();
			add(panelAgendaDay);
			
			//On les mets � jour:
			LocalDate date = currentDate.withDayOfMonth(i);
			Day day = agenda.getDay(date);
			boolean isCurrentDate = agenda.isCurrentDate(date);
			
			panelAgendaDay.update(date, day, isCurrentDate);
		}
		
		this.repaint();
	}
}
