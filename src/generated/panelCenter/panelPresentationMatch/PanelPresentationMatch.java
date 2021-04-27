package generated.panelCenter.panelPresentationMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.DayEvent;
import controller.dayEvents.DayEvent.DAY_EVENTS;
import controller.dayEvents.EventMatch;
import modele.GameData;
import modele.Observer;

import java.awt.GridLayout;

public class PanelPresentationMatch extends JPanel implements Observer {
	private PanelPresentationMatchEquipe panelPresentationMatchEquipeA;
	private PanelPresentationMatchEquipe panelPresentationMatchEquipeB;

	/**
	 * Create the panel.
	 */
	public PanelPresentationMatch() {
		setBorder(new TitledBorder(null, "Presentation Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		panelPresentationMatchEquipeA = new PanelPresentationMatchEquipe();
		add(panelPresentationMatchEquipeA);
		
		panelPresentationMatchEquipeB = new PanelPresentationMatchEquipe();
		add(panelPresentationMatchEquipeB);

	}
	
	@Override
	public void update(GameData gameData) 
	{
		DayEvent currentDayEvent = gameData.getAgenda().getCurrentDayEvent();
		if (currentDayEvent.getEventType() == DAY_EVENTS.MATCH)
		{
			EventMatch currentMatch = (EventMatch) currentDayEvent;
			panelPresentationMatchEquipeA.update(currentMatch.getInGameTeamA());
			panelPresentationMatchEquipeB.update(currentMatch.getInGameTeamB());
		}
	}
}
