package controller.listeners;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.GameData;

public class PanelSouthActionListener implements ActionListener {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	JButton source;
		
	public PanelSouthActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		source = (JButton) e.getSource();
		
		if (e.getSource().equals(mainFrame.getBtnContinue()))
		{
			nextAction();
		}
	}
	
	private void nextAction()
	{
		//On verifie les actions de la journee:
		boolean messagerieOK = actionMessagerie();
		boolean actionOK = actionEvents();
		
		//Si toutes les actions ont été effectuées, on passe au jour suivant:
		if (messagerieOK && actionOK)
			nextDay();
	}
	
	private boolean actionMessagerie()
	{
		return true;
	}
	
	private boolean actionEvents()
	{
		//On récupère les evenements de la journée:
		DayEvent event = gameData.getAgenda().getCurrentDayEvent();
		
		if (!event.isFinished())
		{
			switch(event.getEventType())
			{
			case MATCH:
				eventMatch((EventMatch)event);
				break;
			default:
				break;
			}
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private void nextDay()
	{
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelAgenda");
	}
	
	private void eventMatch(EventMatch match)
	{
		if (!match.isBrifed())
		{
			affichagePresentationMatch(match);
			match.setBrifed(true);
		}
		else
		{
			affichageMatch(match);
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
