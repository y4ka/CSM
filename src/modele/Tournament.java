package modele;

import java.time.LocalDate;

public class Tournament 
{
	private int id;
	private String name;
	private int invitedTeams;
	private LocalDate inscriptionDate;
	private LocalDate startDate;
	
	public Tournament()
	{
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInvitedTeams(int invitedTeams) {
		this.invitedTeams = invitedTeams;
	}

	public void setInscriptionDate(LocalDate inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getInvitedTeams() {
		return invitedTeams;
	}

	public LocalDate getInscriptionDate() {
		return inscriptionDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
}
