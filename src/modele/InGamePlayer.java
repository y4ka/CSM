package modele;

public class InGamePlayer extends Player {
	
	public enum PRIMARY {AK47, M4A4, NONE};
	public enum SECONDARY {USP, GLOCK, NONE};
	public enum KEVLAR {KEVLAR, KEVLAR_HELMET, NONE};
	
	private PRIMARY primaryWeapon;
	private SECONDARY secondaryWeapon;
	private KEVLAR kevlar;
	
	private int kill;
	private int death;
	private int money;
	private int HP;
	
	public InGamePlayer(Player player) //TODO Pourquoi se faire chier avec un héritage alors qu'on peut mettre le Player en variable
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
		
		this.death = 0;
		this.kill = 0;
		this.money = 800;
		this.HP = 100;
	}
	
	public boolean isAlive()
	{
		if (HP <= 0)
			return false;
		else
			return true;
	}
	
	public void takeDamages(int damageValue)
	{
		HP = HP - damageValue;
		if (HP <= 0)
		{
			HP = 0;
			death++;
		}
	}
	
	//Mama
	public void justKilledAMan()
	{
		//Put the gun against his head, pull the trigger now he's dead:
		kill++;
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

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}
}
