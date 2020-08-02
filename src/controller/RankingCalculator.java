package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import generated.MainFrame;
import modele.GameData;
import modele.Team;

public class RankingCalculator 
{
	GameData gameData;
	MainFrame mainFrame;
	
	public RankingCalculator(GameData gameData, MainFrame mainFrame)
	{
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	public void calculateRanking()
	{
		/*
		 * Reminder : Ranking formula
			50% achievements : tournaments performance with time decay
			30% form : matches performance over 3 months
			20% LANs : last 10 LANs results
		 */
		
		sortRanking();
	}
	
	private void sortRanking()
	{
		//Clear the current ranking:
		gameData.getTeamRanking().clear();
		
		//Get all teams and rank them:
		ArrayList<Team> teamRanking = new ArrayList<Team>(gameData.getTeamDatabase().values());
		Collections.sort(teamRanking);
		
		gameData.setTeamRanking(teamRanking);
	}
}
