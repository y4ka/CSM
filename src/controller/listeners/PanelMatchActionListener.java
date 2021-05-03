package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.GameData;

public class PanelMatchActionListener implements ActionListener{
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
		
	public PanelMatchActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart()))
		{
			//On recupere l'evenement en cours:
			EventMatch match = (EventMatch) gameData.getAgenda().getCurrentDayActiveEvent();
			
			//On lance l'evenement:
			match.startEvent();
		}
	}
}
