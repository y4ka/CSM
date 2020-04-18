package controller.dayEvents;

import generated.MainFrame;
import modele.GameData;
import modele.InGamePlayer.KEVLAR;
import modele.InGamePlayer.PRIMARY;
import modele.InGamePlayer.SECONDARY;
import modele.InGameTeam;
import modele.Team;

public class EventMatch implements DayEvent {
	
	// MVC
	GameData gameData;
	MainFrame mainFrame;
	
	private boolean isStarted = false;
	private boolean isFinished = false;
	
	private InGameTeam inGameTeamA;
	private InGameTeam inGameTeamB;
	
	private int roundJoues = 0;
	
	public EventMatch(GameData gameData, MainFrame mainFrame, Team teamA, Team teamB) //TODO Virer les team du constructeur.
	{
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		this.inGameTeamA = teamA.getInGameTeam();
		this.inGameTeamB = teamB.getInGameTeam();
	}
	
	private void chooseSide()
	{
		inGameTeamA.setSide(InGameTeam.SIDE.T);
		inGameTeamB.setSide(InGameTeam.SIDE.CT);
	}
	
	private boolean checkVictory()
	{
		boolean victory = false;
		if (inGameTeamA.getScore() >= 16)
		{
			victory = true;
			System.out.println(inGameTeamA.getName()+" win the game.");
		}
		else if (inGameTeamB.getScore() >= 16)
		{
			victory = true;
			System.out.println(inGameTeamB.getName()+" win the game.");
		}
		return victory;
	}
	
	private boolean checkHalfTime()
	{
		boolean halfTime = false;
		if (roundJoues == 15)
		{
			halfTime = true;
		}
		return halfTime;
	}
	
	private void changeSides()
	{
		showLog("\nHalftime : Teams switches sides.\n");
		inGameTeamA.switchSides();
		inGameTeamB.switchSides();
	}
	
	private void buyRound(InGameTeam team)
	{
		System.out.println(team.getName()+" players buy some weapons.");
		int totalMoneyTeam = 0;
		
		for (int i = 0 ; i < team.getInGamePlayers().length ; i++)
		{
			//Donne secondary:
			if (team.getSide().equals(InGameTeam.SIDE.T))
			{
				team.getInGamePlayers()[i].setSecondaryWeapon(SECONDARY.GLOCK);
			}
			else
			{
				team.getInGamePlayers()[i].setSecondaryWeapon(SECONDARY.USP);
			}
			
			//Calcule argent total equipe:
			totalMoneyTeam += team.getInGamePlayers()[i].getMoney();
		}
		
		//Decide l'achat global de l'equipe:
		for (int i = 0 ; i < team.getInGamePlayers().length ; i++)
		{
			//FULL BUY
			if (totalMoneyTeam > 6000)
			{
				if (team.getSide().equals(InGameTeam.SIDE.T))
				{
					team.getInGamePlayers()[i].setPrimaryWeapon(PRIMARY.AK47);
					team.getInGamePlayers()[i].setKevlar(KEVLAR.KEVLAR_HELMET);
				}
				else
				{
					team.getInGamePlayers()[i].setPrimaryWeapon(PRIMARY.M4A4);
					team.getInGamePlayers()[i].setKevlar(KEVLAR.KEVLAR_HELMET);
				}
			}
		}
	}
	
	private void chooseStrategy(InGameTeam team)
	{
		//Le IGL choisit une strategie:
		team.setCurrentStrategy(team.getInGameStrategies().get(0));
	}
	
	private void playRound()
	{
		float averageTeamARating = 0;
		float averageTeamBRating = 0;
		
		for (int i = 0 ; i < 5 ; i++)
		{
			averageTeamARating += inGameTeamA.getInGamePlayers()[i].getRating();
			averageTeamBRating += inGameTeamB.getInGamePlayers()[i].getRating();
		}
		
		averageTeamARating = averageTeamARating/5;
		averageTeamBRating = averageTeamBRating/5;
		
		if (averageTeamARating >= averageTeamBRating)
		{
			inGameTeamA.winRound();
			inGameTeamB.looseRound();
			showLog("Round over - Winner: "+ inGameTeamA.getSide()+"("+inGameTeamA.getScore()+" - "+inGameTeamB.getScore()+")- Ennemy eliminated");
		}
		else
		{
			inGameTeamA.looseRound();
			inGameTeamB.winRound();
			showLog("Round over - Winner: "+ inGameTeamB.getSide()+"("+inGameTeamA.getScore()+" - "+inGameTeamB.getScore()+")- Ennemy eliminated");
		}
	}

	@Override
	public void startEvent() 
	{
		System.out.println("startEvent MATCH");
		
		//Si le match n'est pas lancé, on le lance:
		if (!isStarted)
		{
			chooseSide();
			isStarted = true;
		}
		
		//Si le match n'est pas terminé on joue un round:
		if (!isFinished) 
		{
			System.out.println("Round "+roundJoues+": "+inGameTeamA.getScore()+" - "+inGameTeamB.getScore());
			showLog("Round started.");
			
			buyRound(inGameTeamA);
			buyRound(inGameTeamB);
			
			//chooseStrategy(inGameTeamA);
			//chooseStrategy(inGameTeamB);
			
			playRound();
			
			roundJoues++;
			
			if (checkHalfTime())
			{
				changeSides();
			}
			
			isFinished = checkVictory();
		}
		else
		{
			showLog("Match terminé");
		}
	}
	
	private void showLog(String log)
	{
		mainFrame.getPanelMatch().getPanelMatchLogs().getTextAreaLogs().append(log+"\n");
	}

	@Override
	public void endEvent() 
	{
		
	}

	@Override
	public DAY_EVENTS getEventType() 
	{
		return DAY_EVENTS.MATCH;
	}

	@Override
	public String getEventDescription() {
		return inGameTeamA.getName()+" vs "+inGameTeamB.getName();
	}

	public InGameTeam getInGameTeamA() {
		return inGameTeamA;
	}

	public void setInGameTeamA(InGameTeam inGameTeamA) {
		this.inGameTeamA = inGameTeamA;
	}

	public InGameTeam getInGameTeamB() {
		return inGameTeamB;
	}

	public void setInGameTeamB(InGameTeam inGameTeamB) {
		this.inGameTeamB = inGameTeamB;
	}
}