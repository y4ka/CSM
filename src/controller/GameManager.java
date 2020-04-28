package controller;

import controller.dayEvents.EventMatch;
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
		
	public GameManager(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	public void nouvellePartie()
	{
		//Chargement de la base de donn�es:
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
		String emailTitle = "Titre 1.";
		String emailContent = "Test du texte d'un email 1.";
		EMail test = new EMail(EMAIL_TYPE.INFORMATION, emailTitle, emailContent);
		gameData.getMessagerie().addEmail(test);
		
		String emailTitle2 = "Titre 2.";
		String emailContent2 = "Test du texte d'un email 2.";
		EMail test2 = new EMail(EMAIL_TYPE.INFORMATION, emailTitle2, emailContent2);
		gameData.getMessagerie().addEmail(test2);
	}
}
