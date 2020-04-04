package controller;

import generated.MainFrame;
import modele.GameData;

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
	}
	
	public void lancerPartie()
	{
		while (true)
		{
			tour();
		}
	}
	
	private void tour()
	{
		generateEvents();
		
		playerTurn();
		
		calculateModifications();
	}
	
	private boolean generateEvents()
	{
		//gameData.getAgenda().addEventToCalendar();
		return true;
	}
	
	private boolean playerTurn()
	{
		return true;
	}
	
	private boolean calculateModifications()
	{
		return true;
	}
}
