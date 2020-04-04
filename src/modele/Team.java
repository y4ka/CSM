package modele;

import java.util.ArrayList;

public class Team {
	
	protected String name;
	protected Player[] players = new Player[5]; //Bench + Actifs
	protected Player coach;
	protected ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	protected InGameTeam inGameTeam;
	
	public Team()
	{
		//inGameTeam = new InGameTeam(this);
	}
	
	public void addPlayer(Player newPlayer)
	{
		for (int i = 0 ; i < players.length ; i++)
		{
			if (players[i] == null)
			{
				players[i] = newPlayer;
				break;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Player getCoach() {
		return coach;
	}

	public void setCoach(Player coach) {
		this.coach = coach;
	}

	public ArrayList<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(ArrayList<Strategy> strategies) {
		this.strategies = strategies;
	}
	
	public InGameTeam getInGameTeam() {
		return inGameTeam;
	}

	public void setInGameTeam(InGameTeam inGameTeam) {
		this.inGameTeam = inGameTeam;
	}

	public Player getPlayer(String nickname)
	{
		Player player = null;
		for (int i = 0 ; i < players.length ; i++)
		{
			if (players[i].getNickname().equals(nickname))
			{
				player = players[i];
				break;
			}
		}
		return player;
	}
}
