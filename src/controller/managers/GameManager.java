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
	}
	
	private void generateMessages()
	{
		String emailTitle = "Bienvenue dans CS:GO Manager 2020";
		String emailContent = "Bienvenue dans CS:GO Manager 2020";
		EMail test = new EMail(EMAIL_TYPE.INFORMATION, emailTitle, emailContent);
		gameData.getMessagerie().addEmail(test);
	}
	
	public void nextAction()
	{
		//TODO:
		//Tant qu'il reste des actions, le bouton continuer permet de lancer l'action du jour.
		//Comme ca si on ajoute des matchs en cours de route, on les ajoute à la liste
		//Si il n'y a plus d'actions du jour, on lance un check de warning sur la messagerie, contracts, etc...
		
		//On verifie les actions de la journee:
		boolean actionOK = actionEvents();
		
		//Si toutes les actions ont été effectuées, on passe au jour suivant:
		if (actionOK)
			nextDay();
		
		//On met à jour la vue:
		mainFrame.update(gameData);
	}
	
	private boolean actionMessagerie()
	{
		return true;
	}
	
	private boolean actionEvents()
	{
		//On récupère les evenements de la journée:
		DayEvent event = gameData.getAgenda().getCurrentDayEvent();
		
		if (event.getEventStatus() != EVENT_STATUS.ENDED)
		{
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
			return false;
		}
		else
		{
			//Envoi du mail compte rendu.
			emailManager.endEventMail(event);
			return true;
		}
	}
	
	private void nextDay()
	{
		//On passe au jour suivant:
		gameData.getAgenda().nextDay();
		
		//On affiche l'agenda:
		mainFrame.getPanelAgenda().update(gameData);
		
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
		cl.show(mainFrame.getPanelCenter(), "panelAgenda");
		
		//On calcule le rating a la fin de chaque journee:
		RankingCalculator rankingCalculator = new RankingCalculator(gameData, mainFrame);
		rankingCalculator.calculateRanking();
		
		//On s'occupe des tournois:
		tournamentManager.checkInscriptions();
	}
	
	private void eventMatch(EventMatch match)
	{
		if (match.getEventStatus() == EVENT_STATUS.NOT_STARTED)
		{
			affichagePresentationMatch(match);
			match.setEventStatus(EVENT_STATUS.BRIEFED);
		}
		else
		{
			affichageMatch(match);
		}
	}
	
	private void affichagePresentationMatch(EventMatch match)
	{
		//On crée la InGameTeam:
		match.createInGameTeam();
		
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
