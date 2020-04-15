package controller;

import controller.dayEvents.EventMatch;
import generated.MainFrame;
import modele.GameData;
import modele.Team;

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
		//Chargement de la base de données:
		gameData.initDatabase();
		
		//Choix de l'equipe du joueur:
		gameData.chooseMyTeam(4);
		
		//Test:
		generateEvents();
	}
	
	private boolean generateEvents()
	{
		Team teamA = gameData.getMonEquipe();
		Team teamB = gameData.getTeam(1);
		EventMatch test = new EventMatch(teamA, teamB);
		gameData.getAgenda().addEventToCalendar(test, gameData.getAgenda().getCurrentDate());
		return true;
	}
}
