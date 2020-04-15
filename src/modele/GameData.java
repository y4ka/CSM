package modele;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import controller.CsvFileHelper;
import controller.dayEvents.Day;
import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;

public class GameData 
{
	private Hashtable<Integer, Player> playerDatabase = new Hashtable<Integer, Player>();
	private Hashtable<Integer, Team> teamDatabase = new Hashtable<Integer, Team>();
	
	private Team monEquipe;
	private Agenda agenda = new Agenda();
	
	private ArrayList<EMail> messagerie = new ArrayList<EMail>();
	
	public GameData()
	{
		
	}
	
	public void initDatabase()
	{
		this.readDataFiles();
		agenda.initCalendar();
	}
	
	public void chooseMyTeam(int id)
	{
		monEquipe = teamDatabase.get(id);
	}
	
	private void readDataFiles()
	{
		ArrayList<String> playersLines = readFile("resources/players.csv");
		createPlayers(playersLines);
		
		ArrayList<String> teamsLines = readFile("resources/teams.csv");
		createTeams(teamsLines);
		
		populateTeams();
		
		createDefaultInGameTeam();
	}
	
	private ArrayList<String> readFile(String path) 
	{
		//On récupère toutes les lignes du fichier:
		ArrayList<String> lines = new ArrayList<String>();
		File file = CsvFileHelper.getResource(path);
		try {
			lines = CsvFileHelper.readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	private void createPlayers(ArrayList<String> lines)
	{
		System.out.println("Create Players and add them to the database: ");
		
		//On parcours toutes les lignes du fichier:
		for (String line : lines) 
		{
			// On divise chaque ligne:
			String[] oneData = line.split(",");

			// On récupere chaque info et on cree les objets Player:
			int id = Integer.parseInt(oneData[0]);
			String nickname = oneData[1];
			String prenom = oneData[2];
			String nom = oneData[3];
			float rating = Float.parseFloat(oneData[4]);
			float headshotPercentage = Float.parseFloat(oneData[5]);
			float damagePerRound = Float.parseFloat(oneData[6]);

			Player newPlayer = new Player();
			newPlayer.setId(id);
			newPlayer.setNickname(nickname);
			newPlayer.setNom(nom);
			newPlayer.setPrenom(prenom);
			newPlayer.setRating(rating);
			newPlayer.setHeadshotPercentage(headshotPercentage);
			newPlayer.setDamagePerRound(damagePerRound);

			playerDatabase.put(id, newPlayer);

			System.out.println("- " + prenom + " \"" + nickname + "\" " + nom);
		}
		System.out.println();
	}
	
	private void createTeams(ArrayList<String> lines)
	{
		System.out.println("Create Teams and add them to the database: ");
		
		//On parcours toutes les lignes du fichier:
		for(String line : lines)
		{
			Team newTeam = new Team();
			
			//On divise chaque ligne:
			 String[] oneData = line.split(",");
	         
			 //On récupere chaque info et on cree les objets Team:
			 int id = Integer.parseInt(oneData[0]);
			 String name = oneData[1];
			 for (int i = 2 ; i <= 6 ; i++)
			 {
				 Player player = playerDatabase.get(Integer.parseInt(oneData[i]));
				 newTeam.addPlayer(player);
			 }
			 
			 //On met a jour les champs de l'equipe:
			 newTeam.setName(name);
			 
			 //On ajoute l'equipe dans la base de donnees:
			 teamDatabase.put(id, newTeam);
			 
			 System.out.println("- "+name);
		}
		
		System.out.println();
	}
	
	private void populateTeams()
	{
		//On comble les vides dans les equipes avec des Smith:
		for (int i = 0 ; i < teamDatabase.size() ; i++)
		{
			System.out.println("Populate team "+teamDatabase.get(i).getName()+" with default player.");
			for (int j = 0 ; j < 5 ; j++)
			{
				teamDatabase.get(i).addPlayer(playerDatabase.get(0));
			}
		}
		System.out.println();
	}
	
	private void createDefaultInGameTeam()
	{
		//On cree une InGameTeam par default pour chaque equipe:
		for (int i = 0 ; i < teamDatabase.size() ; i++)
		{
			System.out.println("Create Default InGameTeam for "+teamDatabase.get(i).getName());
			InGameTeam defaultInGameTeam = new InGameTeam(teamDatabase.get(i));
			teamDatabase.get(i).setInGameTeam(defaultInGameTeam);
		}
		System.out.println();
	}
		
	//=== GETTERS / SETTERS ===
	
	public Player getMyPlayer(int playerTeamID)
	{
		return monEquipe.getPlayers()[playerTeamID];
	}

	public Team getMonEquipe() {
		return monEquipe;
	}

	public void setMonEquipe(Team monEquipe) {
		this.monEquipe = monEquipe;
	}

	public Agenda getAgenda() {
		return agenda;
	}
	
	public Team getTeam(int id)
	{
		if (teamDatabase.containsKey(id))
			return teamDatabase.get(id);
		else
			return null;
	}
}
