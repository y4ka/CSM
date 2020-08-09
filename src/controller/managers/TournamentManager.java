package controller.managers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import controller.dayEvents.Day;
import generated.MainFrame;
import modele.GameData;
import modele.Tournament;

public class TournamentManager 
{
	GameData gameData;
	MainFrame mainFrame;
	
	EmailManager emailManager;
	
	public TournamentManager(GameData gameData, MainFrame mainFrame)
	{
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	public void addEmailManager(EmailManager emailManager)
	{
		this.emailManager = emailManager;
	}
	
	public void checkInscriptions()
	{
		HashMap<Integer, Tournament> tournamentDatabase = gameData.getTournamentDatabase();
		
		Iterator it = tournamentDatabase.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	    	HashMap.Entry pair = (HashMap.Entry)it.next();
	    	Tournament tournament = (Tournament) pair.getValue();
	    	LocalDate inscriptionDate = tournament.getInscriptionDate();
			if  (inscriptionDate.isEqual(gameData.getAgenda().getCurrentDate()))
			{
				emailManager.sendTournamentInscription(tournament);
			}
	    }
	}
	
	public void answerTournamentInvitation(Tournament tournament, boolean answer)
	{
		System.out.println("DADA"+answer);
	}
}
