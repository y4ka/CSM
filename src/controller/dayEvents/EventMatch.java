package controller.dayEvents;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollBar;

import generated.MainFrame;
import modele.GameData;
import modele.InGamePlayer;
import modele.InGamePlayer.KEVLAR;
import modele.InGamePlayer.PRIMARY;
import modele.InGamePlayer.SECONDARY;
import modele.InGameTeam;
import modele.Team;

public class EventMatch extends DayEvent {
	
	// MVC
	GameData gameData;
	MainFrame mainFrame;
	
	private Team teamA;
	private Team teamB;
	
	private InGameTeam inGameTeamA;
	private InGameTeam inGameTeamB;
	
	private final int roundVictoire = 5;
	private final int roundHalf = 4;
	private int roundJoues = 0;
	
	private final int roundDuration = 115;
	private int timeRemaining = roundDuration;
	
	public EventMatch(GameData gameData, MainFrame mainFrame, Team teamA, Team teamB) //TODO Virer les team du constructeur.
	{
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		/*
		 * A la creation de l'evenement, c'est une equipe qu'on invite, on ne sait pas encore quels
		 * InGamePlayers seront selectionn�s lorsque l'�v�nement sera jou�.
		 */
		this.teamA = teamA;
		this.teamB = teamB;
	}
	
	/*
	 * Quand la lineup pour le match est fix�e, on cr�e la InGameTeam:
	 */
	public void createInGameTeam()
	{
		this.inGameTeamA = new InGameTeam(teamA);
		this.inGameTeamB = new InGameTeam(teamB);
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
		if (inGameTeamA.getScore() >= roundVictoire)
		{
			victory = true;
			System.out.println(inGameTeamA.getName()+" win the game.");
			showLog(inGameTeamA.getName()+" win the game.");
		}
		else if (inGameTeamB.getScore() >= roundVictoire)
		{
			victory = true;
			System.out.println(inGameTeamB.getName()+" win the game.");
			showLog(inGameTeamB.getName()+" win the game.");
		}
		return victory;
	}
	
	private boolean checkHalfTime()
	{
		boolean halfTime = false;
		if (roundJoues == roundHalf)
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
	
	private void playRoundV3()
	{
		showLog("Round started.");
		
		//On lance un timer:
		Timer timer = new Timer();
		RoundTask roundTask = new RoundTask(mainFrame, this);
		timer.schedule(roundTask, 0, 75);
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
			//On d�sactive le bouton pour ne pas lancer deux rounds simultan�ment:
			mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart().setEnabled(false);
			
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
			
			//On v�rifie si une equipe a gagn� le round et on annule la tache:
			if (allPlayersAreDead(inGameTeamA))
			{
				roundResult(inGameTeamB,inGameTeamA);
				this.cancel();
				mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart().setEnabled(true);
			}
			else if (allPlayersAreDead(inGameTeamB))
			{
				roundResult(inGameTeamA,inGameTeamB);
				this.cancel();
				mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart().setEnabled(true);
			}
			
			//Mise � jour du temps restant:
			timeRemaining--;
			mainFrame.getPanelMatch().update(eventMatch);
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
		
		//Ils tirent chacun leur tour jusqu'� ce qu'un meurt:
		while (playerA.isAlive() && playerB.isAlive())
		{
			shootAt(currentShooter, currentVictim);
			
			System.out.println("HP restants: "+playerA.getNickname()+"="+playerA.getHP()+" / "+playerB.getNickname()+"="+playerB.getHP());
			
			//On inverse les roles:
			InGamePlayer tmp = currentShooter;
			currentShooter = currentVictim;
			currentVictim = tmp;
		}
		
		//On affiche qui a gagn� le duel:
		if (playerA.isAlive()) {
			showLog(playerA.getNickname()+" kill "+playerB.getNickname());
			System.out.println(playerB.getNickname()+" est mort.");
		}
		else {
			showLog(playerB.getNickname()+" kill "+playerA.getNickname());
			System.out.println(playerA.getNickname()+" est mort.");
		}
		
		//On met � jour la vue:
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
		System.out.println("allPlayersAreDead ("+inGameTeam.getName()+") -> "+allPlayersAreDead);
		return allPlayersAreDead;
	}

	private void roundResult(InGameTeam roundWinner, InGameTeam roundLooser)
	{
		roundWinner.winRound();
		roundLooser.looseRound();
		
		showLog("Round over - Winner: "+ roundWinner.getSide()+"("+roundWinner.getScore()+" - "+roundLooser.getScore()+")- Ennemy eliminated\n");
	}
	
	@Override
	public void startEvent() 
	{
		System.out.println("startEvent MATCH");
		
		//Si le match n'est pas lanc�, on le lance:
		if (!started)
		{
			chooseSide();
			
			started = true;
		}
		else
		{
			//Si le match n'est pas termin� on joue un round:
			if (!finished) 
			{
				startRound();
				
				finished = checkVictory();
				
				//On met � jour la vue:
				mainFrame.getPanelMatch().update(this);
			}
		}
	}
	
	private void startRound()
	{
		System.out.println("Round "+roundJoues+": "+inGameTeamA.getScore()+" - "+inGameTeamB.getScore());
		
		//Les equipes choisissent une strat�gie:
		//chooseStrategy(inGameTeamA);
		//chooseStrategy(inGameTeamB);
		
		//Les joueurs font leurs achats:
		buyRound(inGameTeamA);
		buyRound(inGameTeamB);
		
		//On joue le round:
		playRoundV3();
		
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
		JScrollBar vertical = mainFrame.getPanelMatch().getPanelMatchLogs().getScrollPane().getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum() );
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
		return teamA.getName()+" vs "+teamB.getName();
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