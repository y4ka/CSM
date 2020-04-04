package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generated.MainFrame;
import modele.GameData;

public class PanelAgendaActionListener implements ActionListener {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
		
	public PanelAgendaActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(mainFrame.getBtnContinue()))
		{
			gameData.getAgenda().getCurrentDayEvent().startEvent();
		}
	}
}
