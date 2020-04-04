package modele;

public class InGamePlayer extends Player {
	
	public enum PRIMARY {AK47, M4A4, NONE};
	public enum SECONDARY {USP, GLOCK, NONE};
	public enum KEVLAR {KEVLAR, KEVLAR_HELMET, NONE};
	
	private PRIMARY primaryWeapon;
	private SECONDARY secondaryWeapon;
	private KEVLAR kevlar;
	
	private int money;
	
	public InGamePlayer(Player player)
	{
		//Initialisation de la super class:
		super.id = player.getId();
		super.nickname = player.getNickname();
		super.nom = player.getNom();
		super.prenom = player.getPrenom();
		super.rating = player.getRating();
		super.headshotPercentage = player.getHeadshotPercentage();
		super.damagePerRound = player.getDamagePerRound();
		
		//Initialisation des champs de la class:
		this.primaryWeapon = PRIMARY.NONE;
		this.secondaryWeapon = SECONDARY.NONE;
		this.kevlar = KEVLAR.NONE;
		
		this.money = 800;
	}

	public PRIMARY getPrimaryWeapon() {
		return primaryWeapon;
	}

	public void setPrimaryWeapon(PRIMARY primaryWeapon) {
		this.primaryWeapon = primaryWeapon;
	}

	public SECONDARY getSecondaryWeapon() {
		return secondaryWeapon;
	}

	public void setSecondaryWeapon(SECONDARY secondaryWeapon) {
		this.secondaryWeapon = secondaryWeapon;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public KEVLAR getKevlar() {
		return kevlar;
	}

	public void setKevlar(KEVLAR kevlar) {
		this.kevlar = kevlar;
	}
}
