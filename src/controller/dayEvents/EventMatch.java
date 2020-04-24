package controller.dayEvents;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import generated.MainFrame;
import modele.GameData;
import modele.InGamePlayer;
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
	
	private final int roundDuration = 115;
	private int timeRemaining = roundDuration;
	
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
		
		showLog(inGameTeamA.getName()+" choose side "+inGameTeamA.getSide().toString());
		showLog(inGameTeamB.getName()+" choose side "+inGameTeamB.getSide().toString());
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
	
	@Deprecated
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
		
		//Determination du vainqueur du round:
		if (averageTeamARating >= averageTeamBRating)
			roundResult(inGameTeamA, inGameTeamB);
		else
			roundResult(inGameTeamB, inGameTeamA);
	}
	
	private void playRoundV2()
	{
		for (InGamePlayer playerA : inGameTeamA.getInGamePlayers())
		{
			if (playerA.isAlive())
			{
				for (InGamePlayer playerB : inGameTeamB.getInGamePlayers())
				{
					if (playerB.isAlive())
					{
						duel(playerA, playerB);
						
						//Si le joueur A est mort, on passe a un autre joueur A:
						if (!playerA.isAlive())
						{
							break;
						}
					}
				}
				if (allPlayersAreDead(inGameTeamB))
				{
					//roundResult(inGameTeamA,inGameTeamB);
					break;
				}
			}
		}
		if (allPlayersAreDead(inGameTeamA))
		{
			roundResult(inGameTeamB,inGameTeamA);
		}
		else if (allPlayersAreDead(inGameTeamB))
		{
			roundResult(inGameTeamA,inGameTeamB);
		}
	}
	
	private void playRoundV3()
	{
		//On lance un timer:
		Timer timer = new Timer();
		RoundTask roundTask = new RoundTask(mainFrame, this);
		timer.schedule(roundTask, 0, 2*1000);
	}
	
	class RoundTask extends TimerTask
	{
		private MainFrame mainFrame;
		private EventMatch eventMatch;
		
		public RoundTask(MainFrame mainFrame, EventMatch eventMatch)
		{
			this.mainFrame = mainFrame;
			this.eventMatch = eventMatch;
		}
		
		@Override
		public void run() 
		{
			System.out.println("TOP");
			
			//A chaque tick, on fait un duel:
			boolean duelTermine = false;
			for (InGamePlayer playerA : inGameTeamA.getInGamePlayers())
			{
				if (playerA.isAlive())
				{
					for (InGamePlayer playerB : inGameTeamB.getInGamePlayers())
					{
						if (playerB.isAlive())
						{
							duel(playerA, playerB);
							duelTermine = true;
							break;
						}
					}
					if (duelTermine)
						break;
				}
			}
			
			//On vérifie si une equipe a gagné et on annule la tache:
			if (allPlayersAreDead(inGameTeamA))
			{
				roundResult(inGameTeamB,inGameTeamA);
				this.cancel();
			}
			else if (allPlayersAreDead(inGameTeamB))
			{
				roundResult(inGameTeamA,inGameTeamB);
				this.cancel();
			}
			
			//Mise à jour du temps restant:
			timeRemaining--;
			mainFrame.getPanelMatch().getPanelMatchLogs().update(eventMatch);
		}
	}
	
	private void duel(InGamePlayer playerA, InGamePlayer playerB)
	{
		//Le joueur avec le plus haut rating tire en premier:
		InGamePlayer currentShooter;
		InGamePlayer currentVictim;
		if (playerA.getRating() > playerB.getRating())
		{
			currentShooter = playerA;
			currentVictim = playerB;
		}
		else if (playerA.getRating() < playerB.getRating())
		{
			currentShooter = playerB;
			currentVictim = playerA;
		}
		else
		{
			Random rd = new Random();
			if (rd.nextBoolean())
			{
				currentShooter = playerB;
				currentVictim = playerA;
			}
			else
			{
				currentShooter = playerA;
				currentVictim = playerB;
			}
		}
		System.out.println(currentShooter.getNickname()+" tire en premier sur "+currentVictim.getNickname());
		
		//Ils tirent chacun leur tour jusqu'à ce qu'un meurt:
		while (playerA.isAlive() && playerB.isAlive())
		{
			shootAt(currentShooter, currentVictim);
			
			System.out.println("HP restants: "+playerA.getNickname()+"="+playerA.getHP()+" / "+playerB.getNickname()+"="+playerB.getHP());
			
			//On inverse les roles:
			InGamePlayer tmp = currentShooter;
			currentShooter = currentVictim;
			currentVictim = tmp;
		}
		
		//On affiche qui a gagné le duel:
		if (playerA.isAlive()) {
			showLog(playerA.getNickname()+" kill "+playerB.getNickname());
			System.out.println(playerB.getNickname()+" est mort.");
		}
		else {
			showLog(playerB.getNickname()+" kill "+playerA.getNickname());
			System.out.println(playerA.getNickname()+" est mort.");
		}
		
		//On met à jour la vue:
		mainFrame.getPanelMatch().update(this);
	}
	
	private void shootAt(InGamePlayer playerA, InGamePlayer playerB)
	{
		System.out.println(playerA.getNickname()+" tire sur "+playerB.getNickname()+" !");
		float headshotPercentage = playerA.getHeadshotPercentage();
		
		Random rd = new Random();
	    float result = rd.nextFloat()*100;
	    
	    if (result <= headshotPercentage)
	    {
	    	System.out.println("HEADSHOT !");
	    	playerB.takeDamages(100);
	    }
	    else
	    {
	    	playerB.takeDamages(25);
	    }
	}
	
	private boolean allPlayersAreDead(InGameTeam inGameTeam)
	{
		boolean allPlayersAreDead = true;
		for (InGamePlayer inGamePlayer : inGameTeam.getInGamePlayers())
		{
			if (inGamePlayer.isAlive())
			{
				allPlayersAreDead = false;
			}
		}
		System.out.println("allPlayersAreDead -> "+allPlayersAreDead);
		return allPlayersAreDead;
	}

	private void roundResult(InGameTeam roundWinner, InGameTeam roundLooser)
	{
		roundWinner.winRound();
		roundLooser.looseRound();
		
		showLog("Round over - Winner: "+ roundWinner.getSide()+"("+roundWinner.getScore()+" - "+roundLooser.getScore()+")- Ennemy eliminated");
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
		else
		{
			//Si le match n'est pas terminé on joue un round:
			if (!isFinished) 
			{
				startRound();
				
				isFinished = checkVictory();
				
				//On met à jour la vue:
				mainFrame.getPanelMatch().update(this);
			}
			else
			{
				showLog("Match terminé");
			}
		}
	}
	
	private void startRound()
	{
		//Les equipes choisissent une stratégie:
		//chooseStrategy(inGameTeamA);
		//chooseStrategy(inGameTeamB);
		
		//Les joueurs font leurs achats:
		buyRound(inGameTeamA);
		buyRound(inGameTeamB);
		
		System.out.println("Round "+roundJoues+": "+inGameTeamA.getScore()+" - "+inGameTeamB.getScore());
		showLog("Round started.");
		
		//playRound();
		playRoundV3();
		
		showLog("Round ended.");
		
		//On reset toutes les valeurs des deux equipes:
		endRound(inGameTeamA);
		endRound(inGameTeamB);
		
		//Reset round timer:
		timeRemaining = roundDuration;
		
		//Verifie le changement de side:
		if (checkHalfTime())
		{
			changeSides();
		}
		
		roundJoues++;
	}
	
	private void endRound(InGameTeam team)
	{
		//Reset les HP des joueurs:
		for (InGamePlayer player : team.getInGamePlayers())
		{
			player.setHP(100);
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

	public int getTimeRemaining() {
		return timeRemaining;
	}	
}