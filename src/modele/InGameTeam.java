package modele;

import java.util.ArrayList;

public class InGameTeam extends Team
{
	public enum SIDE {T, CT};
	
	private InGamePlayer[] inGamePlayers = new InGamePlayer[5];
	private SIDE side;
	private int score;
	
	protected ArrayList<InGameStrategy> inGameStrategies = new ArrayList<InGameStrategy>();
	private InGameStrategy currentStrategy;
	
	public InGameTeam(Team team)
	{
		//Initialisation de la super class:
		super.coach = team.getCoach();
		super.name = team.getName();
		super.players = team.getPlayers();
		super.strategies = team.getStrategies();
		
		//Initialisation des champs de la class:
		for (int i = 0 ; i < inGamePlayers.length ; i++)
		{
			InGamePlayer newInGamePlayer = new InGamePlayer(team.getPlayers()[i]);
			inGamePlayers[i] = newInGamePlayer;
		}
	}

	public SIDE getSide() {
		return side;
	}

	public void setSide(SIDE side) {
		this.side = side;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public InGamePlayer[] getInGamePlayers() {
		return inGamePlayers;
	}

	public void setInGamePlayers(InGamePlayer[] inGamePlayers) {
		this.inGamePlayers = inGamePlayers;
	}

	public ArrayList<InGameStrategy> getInGameStrategies() {
		return inGameStrategies;
	}

	public void setInGameStrategies(ArrayList<InGameStrategy> inGameStrategies) {
		this.inGameStrategies = inGameStrategies;
	}

	public InGameStrategy getCurrentStrategy() {
		return currentStrategy;
	}

	public void setCurrentStrategy(InGameStrategy currentStrategy) {
		this.currentStrategy = currentStrategy;
	}
	
	public void addInGamePlayers(InGamePlayer inGamePlayer)
	{
		for (int i = 0 ; i < inGamePlayers.length ; i++)
		{
			if (inGamePlayers[i] == null)
			{
				inGamePlayers[i] = inGamePlayer;
				break;
			}
		}
	}
	
	public void switchSides()
	{
		if (side.equals(SIDE.CT))
		{
			side = SIDE.T;
		}
		else
		{
			side = SIDE.CT;
		}
	}
	
	public void winRound()
	{
		score++;
	}
	
	public void looseRound()
	{
		
	}
}
