package modele;

import javax.swing.ImageIcon;

public class Player 
{
	protected int id;
	protected String nickname;
	protected String nom;
	protected String prenom;
	protected ImageIcon image;
	
	protected float rating;
	protected float headshotPercentage;
	protected float damagePerRound;
	
	public Player() 
	{
		
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getHeadshotPercentage() {
		return headshotPercentage;
	}

	public void setHeadshotPercentage(float headshotPercentage) {
		this.headshotPercentage = headshotPercentage;
	}

	public float getDamagePerRound() {
		return damagePerRound;
	}

	public void setDamagePerRound(float damagePerRound) {
		this.damagePerRound = damagePerRound;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
}