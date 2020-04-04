package modele;

import java.util.ArrayList;

public class InGameStrategy extends Strategy {
	
	private ArrayList<InGamePlayer> inGamePlayersA = new ArrayList<InGamePlayer>();
	private ArrayList<InGamePlayer> inGamePlayersB = new ArrayList<InGamePlayer>();
	private ArrayList<InGamePlayer> inGamePlayersMID = new ArrayList<InGamePlayer>();
	
	public InGameStrategy(Strategy strategy)
	{
		super.playersA = strategy.getPlayersA();
		super.playersB = strategy.getPlayersB();
		super.playersMID = strategy.getPlayersMID();
		
		super.playersAStrategy = strategy.getPlayersAStrategy();
		super.playersBStrategy = strategy.getPlayersBStrategy();
		super.playersMidStrategy = strategy.getPlayersMidStrategy();
		
		//Manque les InGamePlayers
	}

	public ArrayList<InGamePlayer> getInGamePlayersA() {
		return inGamePlayersA;
	}

	public void setInGamePlayersA(ArrayList<InGamePlayer> inGamePlayersA) {
		this.inGamePlayersA = inGamePlayersA;
	}

	public ArrayList<InGamePlayer> getInGamePlayersB() {
		return inGamePlayersB;
	}

	public void setInGamePlayersB(ArrayList<InGamePlayer> inGamePlayersB) {
		this.inGamePlayersB = inGamePlayersB;
	}

	public ArrayList<InGamePlayer> getInGamePlayersMID() {
		return inGamePlayersMID;
	}

	public void setInGamePlayersMID(ArrayList<InGamePlayer> inGamePlayersMID) {
		this.inGamePlayersMID = inGamePlayersMID;
	}
}
