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
		//On regarde si tous les mails avec action on �t� r�pondus:
		boolean messagerieOK = checkMessagerie();
		
		//Quand tous les mails ont �t� r�pondus, on regarde si il y a un event:
		if (messagerieOK)
		{
			boolean eventsOK = events();
			
			//Quand tous les evenements ont �t� r�pondus, on passe au jour suivant:
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
		//On r�cup�re les evenements de la journ�e:
		DayEvent event = gameData.getAgenda().getCurrentDayEvent();
		
		//Selon le type d'�v�nement, l'IHM ne va pas etre la meme:
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
		//Met � jour les donn�es du panneau Agenda:
		mainFrame.getPanelPresentationMatch().update(match);
				
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelPresentationMatch");
	}
}
