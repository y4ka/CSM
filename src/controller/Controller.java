package controller;

import controller.listeners.PanelMatchActionListener;
import controller.listeners.PanelMenuActionListener;
import controller.listeners.PanelSouthActionListener;
import controller.listeners.PanelTactiquesActionListener;
import controller.managers.GameManager;
import generated.MainFrame;
import modele.GameData;

public class Controller {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Listeners
	PanelMenuActionListener panelMenuActionListener;
	PanelTactiquesActionListener panelTactiquesActionListener;
	PanelSouthActionListener panelSouthActionListener;
	PanelMatchActionListener panelMatchActionListener;
	
	//Managers
	GameManager gameManager;
	
	public Controller(GameData gameData, MainFrame mainFrame) {
		
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		//Listeners
		this.panelMenuActionListener = new PanelMenuActionListener(gameData, mainFrame);
		this.panelTactiquesActionListener = new PanelTactiquesActionListener(gameData, mainFrame);
		this.panelSouthActionListener = new PanelSouthActionListener(gameData, mainFrame);
		this.panelMatchActionListener = new PanelMatchActionListener(gameData, mainFrame);
		
		//Managers
		gameManager = new GameManager(gameData, mainFrame);
		panelSouthActionListener.addGameManager(gameManager);
	}
	
	public void initController() {
		
		//panelMenuActionListener
		mainFrame.getPanelMenu().getBtnEquipe().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnMessagerie().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnAgenda().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnBudget().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnTactiques().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnRanking().addActionListener(panelMenuActionListener);
		
		//panelTactiquesActionListener
		mainFrame.getComboBoxTactiqueJoueur1().addActionListener(panelTactiquesActionListener);
		mainFrame.getComboBoxTactiqueJoueur2().addActionListener(panelTactiquesActionListener);
		
		mainFrame.getComboBoxSiteJoueur1().addActionListener(panelTactiquesActionListener);
		mainFrame.getComboBoxSiteJoueur2().addActionListener(panelTactiquesActionListener);
		
		mainFrame.getBtnTactiqueSauvegarder().addActionListener(panelTactiquesActionListener);
		
		//panelMatchActionListener
		mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart().addActionListener(panelMatchActionListener);
		
		//panelSouthActionListener
		mainFrame.getBtnContinue().addActionListener(panelSouthActionListener);
	}
	
	public void nouvellePartie() {
		gameManager.nouvellePartie();
	}
}
