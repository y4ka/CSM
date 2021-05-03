package controller.managers;

import java.awt.CardLayout;

import controller.RankingCalculator;
import controller.dayEvents.DayEvent;
import controller.dayEvents.DayEvent.EVENT_STATUS;
import controller.dayEvents.EventMatch;
import controller.dayEvents.EventRepos;
import generated.MainFrame;
import modele.EMail;
import modele.GameData;
import modele.Team;
import modele.EMail.EMAIL_TYPE;

public class GameManager
{
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Managers:
	EmailManager emailManager;
	TournamentManager tournamentManager;
		
	public GameManager(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		//Managers:
		this.emailManager = new EmailManager(gameData, mainFrame);
		this.tournamentManager = new TournamentManager(gameData, mainFrame);
		
		tournamentManager.addEmailManager(emailManager);
		emailManager.addTournamentManager(tournamentManager);
		
	}
	
	public void nouvellePartie()
	{
		//Chargement de la base de données:
		gameData.initDatabase();
		
		//Choix de l'equipe du joueur:
		gameData.chooseMyTeam(4);
		
		//Test:
		generateEvents();
		generateMessages();
		
		//GameLoop
		GameLoop gameLoop = new GameLoop(mainFrame, gameData);
		gameLoop.start();
	}
	
	private void generateEvents()
	{
		//TODO entre le moment ou le match est cree et ou il est joue, les equipes ont change donc systeme d'ID et recuperation au lancement de l'event ?
		Team teamA = gameData.getMonEquipe();
		Team teamB = gameData.getTeam(1);
		EventMatch test = new EventMatch(gameData, mainFrame, teamA, teamB);
		gameData.getAgenda().addEventToCalendar(test, gameData.getAgenda().getCurrentDate());
		
		Team teamC = gameData.getMonEquipe();
		Team teamD = gameData.getTeam(2);
		EventMatch test2 = new EventMatch(gameData, mainFrame, teamC, teamD);
		gameData.getAgenda().addEventToCalendar(test2, gameData.getAgenda().getCurrentDate().plusDays(2));
		
		EventMatch test3 = new EventMatch(gameData, mainFrame, teamC, teamD);
		gameData.getAgenda().addEventToCalendar(test3, gameData.getAgenda().getCurrentDate());
	}
	
	private void generateMessages()
	{
		String emailTitle = "Bienvenue dans CS:GO Manager 2020";
		String emailContent = "Bienvenue dans CS:GO Manager 2020";
		EMail test = new EMail(EMAIL_TYPE.INFORMATION, emailTitle, emailContent);
		gameData.getMessagerie().addEmail(test);
	}
	
	//Appelé par le bouton suivant:
	public void nextAction()
	{
		//Si tous les evenements de la journée sont terminés, on passe au jour suivant:
		if (gameData.getAgenda().isCurrentDayEventsAllFinished())
		{
			nextDay();
		}
		//Si il reste de evenements en cours, on les lance:
		else
		{
			actionEvents();
		}
	}
	
	private boolean actionMessagerie()
	{
		return true;
	}
	
	private void actionEvents()
	{
		//On fait avancer l'événement courant de la journée:
		DayEvent event = gameData.getAgenda().getCurrentDayActiveEvent();
		
		switch(event.getEventType())
		{
		case MATCH:
			eventMatch((EventMatch)event);
			break;
		case REPOS:
			eventRepos((EventRepos)event);
		default:
			break;
		}
	}
	
	private void nextDay()
	{
		//On passe au jour suivant:
		gameData.getAgenda().nextDay();
		
		//On affiche l'agenda:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelAgenda");
		
		//On calcule le rating a la fin de chaque journee:
		RankingCalculator rankingCalculator = new RankingCalculator(gameData, mainFrame);
		rankingCalculator.calculateRanking();
		
		//On s'occupe des tournois:
		tournamentManager.checkInscriptions();
	}
	
	//TODO Plutot deplacer dans les classes respectives ?
	private void eventMatch(EventMatch match)
	{
		EVENT_STATUS eventStatus = match.getEventStatus();
		switch (eventStatus)
		{
			case NOT_STARTED:
			{
				affichagePresentationMatch(match);
				match.setEventStatus(EVENT_STATUS.BRIEFING);
				break;
			}
			case BRIEFING:
			case STARTED:
			{
				affichageMatch(match);
				break;
			}
			case DEBRIEFING:
			{
				match.setEventStatus(EVENT_STATUS.ENDED);
				
				CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
				cl.show(mainFrame.getPanelCenter(), "panelAgenda");
				break;
			}
			case ENDED:
			{
				
			}
		}
	}
	
	private void affichagePresentationMatch(EventMatch match)
	{
		//On crée la InGameTeam:
		match.createInGameTeam();
				
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelPresentationMatch");
	}
	
	private void affichageMatch(EventMatch match)
	{	
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelMatch");
	}
	
	//TODO Plutot deplacer dans les classes respectives ?
	private void eventRepos(EventRepos repos)
	{
		repos.setEventStatus(EVENT_STATUS.ENDED);
	}

	public EmailManager getEmailManager() {
		return emailManager;
	}

	public TournamentManager getTournamentManager() {
		return tournamentManager;
	}
}
