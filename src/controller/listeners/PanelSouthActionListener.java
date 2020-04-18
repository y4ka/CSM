package controller.listeners;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.GameData;

public class PanelSouthActionListener implements ActionListener {
	
	private boolean presentationMatch= false;
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
		
	public PanelSouthActionListener(GameData gameData, MainFrame mainFrame)
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
			nextAction();
		}
	}
	
	public void nextAction()
	{
		//On regarde si tous les mails avec action on été répondus:
		boolean messagerieOK = actionMessagerie();
		
		//Quand tous les mails ont été répondus, on regarde si il y a un event:
		if (messagerieOK)
		{
			boolean eventsOK = actionEvents();
			
			//Quand tous les evenements ont été répondus, on passe au jour suivant:
			if (eventsOK)
			{
				nextDay();
			}
		}
	}
	
	private boolean actionMessagerie()
	{
		return true;
	}
	
	private boolean actionEvents()
	{
		//On récupère les evenements de la journée:
		DayEvent event = gameData.getAgenda().getCurrentDayEvent();
		
		//Selon le type d'événement, l'IHM ne va pas etre la meme:
		switch(event.getEventType())
		{
		case MATCH:
			eventMatch((EventMatch)event);
			break;
		default:
			break;
		}
		return true;
	}
	
	private void nextDay()
	{
		
	}
	
	private void eventMatch(EventMatch match)
	{
		if (!presentationMatch)
		{
			affichagePresentationMatch(match);
			presentationMatch = true;
		}
		else
		{
			affichageMatch(match);
			presentationMatch = false;
		}
	}
	
	private void affichagePresentationMatch(EventMatch match)
	{
		//Met à jour les données du panneau PresentationMatch:
		mainFrame.getPanelPresentationMatch().update(match);
				
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelPresentationMatch");
	}
	
	private void affichageMatch(EventMatch match)
	{
		//Met à jour les données du panneau Match:
		mainFrame.getPanelMatch().update(match);
		
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelMatch");
	}
}
