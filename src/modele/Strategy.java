package modele;

import java.util.ArrayList;

public class Strategy 
{
	public enum T_STRATEGY {EXECUTE, CONTROL, PICK, RUSH, FAKE};
	
	protected ArrayList<Player> playersA = new ArrayList<Player>();
	protected ArrayList<Player> playersB = new ArrayList<Player>();
	protected ArrayList<Player> playersMID = new ArrayList<Player>();
	
	protected T_STRATEGY playersAStrategy;
	protected T_STRATEGY playersBStrategy;
	protected T_STRATEGY playersMidStrategy;
	
	public Strategy()
	{
		
	}
	
	public void defautInitialisation(Team team)
	{
		playersA.add(team.getPlayers()[0]);
		playersA.add(team.getPlayers()[1]);
		playersMID.add(team.getPlayers()[2]);
		playersB.add(team.getPlayers()[3]);
		playersB.add(team.getPlayers()[4]);
		
		playersAStrategy = T_STRATEGY.CONTROL;
		playersBStrategy = T_STRATEGY.CONTROL;
		playersMidStrategy = T_STRATEGY.CONTROL;
	}

	public ArrayList<Player> getPlayersA() {
		return playersA;
	}

	public void setPlayersA(ArrayList<Player> playersA) {
		this.playersA = playersA;
	}

	public ArrayList<Player> getPlayersB() {
		return playersB;
	}

	public void setPlayersB(ArrayList<Player> playersB) {
		this.playersB = playersB;
	}

	public ArrayList<Player> getPlayersMID() {
		return playersMID;
	}

	public void setPlayersMID(ArrayList<Player> playersMID) {
		this.playersMID = playersMID;
	}

	public T_STRATEGY getPlayersAStrategy() {
		return playersAStrategy;
	}

	public void setPlayersAStrategy(T_STRATEGY playersAStrategy) {
		this.playersAStrategy = playersAStrategy;
	}

	public T_STRATEGY getPlayersBStrategy() {
		return playersBStrategy;
	}

	public void setPlayersBStrategy(T_STRATEGY playersBStrategy) {
		this.playersBStrategy = playersBStrategy;
	}

	public T_STRATEGY getPlayersMidStrategy() {
		return playersMidStrategy;
	}

	public void setPlayersMidStrategy(T_STRATEGY playersMidStrategy) {
		this.playersMidStrategy = playersMidStrategy;
	}
}
