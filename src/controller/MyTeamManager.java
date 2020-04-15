package controller;

import java.awt.CardLayout;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.GameData;

public class MyTeamManager 
{
	//MVC
	GameData gameData;
	MainFrame mainFrame;
		
	public MyTeamManager(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	public void nextAction()
	{
		//On regarde si tous les mails avec action on été répondus:
		boolean messagerieOK = checkMessagerie();
		
		//Quand tous les mails ont été répondus, on regarde si il y a un event:
		if (messagerieOK)
		{
			boolean eventsOK = events();
			
			//Quand tous les evenements ont été répondus, on passe au jour suivant:
			if (eventsOK)
			{
				nextDay();
			}
		}
	}
	
	private boolean checkMessagerie()
	{
		return true;
	}
	
	private boolean events()
	{
		//On récupère les evenements de la journée:
		DayEvent event = gameData.getAgenda().getCurrentDayEvent();
		
		//Selon le type d'événement, l'IHM ne va pas etre la meme:
		switch(event.getEventType())
		{
		case MATCH:
			affichagePresentationMatch((EventMatch) event);
			break;
		default:
			break;
		}
		return true;
	}
	
	private void nextDay()
	{
		
	}
	
	private void affichagePresentationMatch(EventMatch match)
	{
		//Met à jour les données du panneau Agenda:
		mainFrame.getPanelPresentationMatch().update(match);
				
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelPresentationMatch");
	}
}
