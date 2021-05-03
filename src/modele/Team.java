package modele;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Team implements Comparable {
	
	protected String name;
	protected ImageIcon image;
	protected int rankingPoints;
	protected Player[] players = new Player[5]; //Bench + Actifs
	protected Player coach;
	protected ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	protected InGameTeam inGameTeam;
	
	public Team()
	{
		//inGameTeam = new InGameTeam(this);
		rankingPoints = 0;
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

	public int getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
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

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
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

	@Override
	public int compareTo(Object o) 
	{
		Team comparedTeam = (Team) o;
		if (rankingPoints <= comparedTeam.rankingPoints)
			return 1;
		else
			return -1;
	}
}
