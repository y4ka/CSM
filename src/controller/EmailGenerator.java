package controller;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.EMail;
import modele.EMail.EMAIL_TYPE;
import modele.GameData;

public class EmailGenerator 
{
	GameData gameData;
	MainFrame mainFrame;
	
	public EmailGenerator(GameData gameData, MainFrame mainFrame)
	{
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	public void endEventMail(DayEvent event)
	{
		EMAIL_TYPE emailType 	= EMAIL_TYPE.INFORMATION;
		String title 			= event.getEventDescription();
		String content 			= event.getEventDescription()+" a eu lieu.";
		
		switch(event.getEventType())
		{
		case MATCH:
			content = eventMatchContent((EventMatch)event);
			break;
		case COHESION:
			break;
		case DEPLACEMENT:
			break;
		case ENRAINEMENT_INDIVIDUEL:
			break;
		case ENTRAINEMENT_COLLECTIF:
			break;
		case REPOS:
			break;
		case SPORT:
			break;
		default:
			break;
		}
		
		EMail email = new EMail(emailType, title, content);
		gameData.getMessagerie().addEmail(email);
	}
	
	private String eventMatchContent(EventMatch event)
	{
		String content = "Le match opposant "+event.getInGameTeamA().getName()+" à "+event.getInGameTeamB().getName()+" s'est terminé sur un score de "+event.getInGameTeamA().getScore()
				+" à "+event.getInGameTeamB().getScore()+".\n";
		return content;
	}
}
