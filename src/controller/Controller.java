package controller;

import controller.listeners.PanelAgendaActionListener;
import controller.listeners.PanelLineupActionListener;
import controller.listeners.PanelMenuActionListener;
import controller.listeners.PanelSouthActionListener;
import controller.listeners.PanelTactiquesActionListener;
import generated.MainFrame;
import modele.GameData;

public class Controller {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Listeners
	PanelMenuActionListener panelMenuActionListener;
	PanelTactiquesActionListener panelTactiquesActionListener;
	PanelLineupActionListener panelLineupActionListener;
	PanelAgendaActionListener panelAgendaActionListener;
	PanelSouthActionListener panelSouthActionListener;
	
	public Controller(GameData gameData, MainFrame mainFrame) {
		
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		//Listeners
		this.panelMenuActionListener = new PanelMenuActionListener(gameData, mainFrame);
		this.panelTactiquesActionListener = new PanelTactiquesActionListener(gameData, mainFrame);
		this.panelLineupActionListener = new PanelLineupActionListener(gameData, mainFrame);
		this.panelAgendaActionListener = new PanelAgendaActionListener(gameData, mainFrame);
		this.panelSouthActionListener = new PanelSouthActionListener(gameData, mainFrame);
	}
	
	public void initController() {
		
		//panelMenuActionListener
		mainFrame.getPanelMenu().getBtnEquipe().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnMessagerie().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnAgenda().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnBudget().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnTactiques().addActionListener(panelMenuActionListener);
		mainFrame.getPanelMenu().getBtnLineup().addActionListener(panelMenuActionListener);
		
		//panelTactiquesActionListener
		mainFrame.getComboBoxTactiqueJoueur1().addActionListener(panelTactiquesActionListener);
		mainFrame.getComboBoxTactiqueJoueur2().addActionListener(panelTactiquesActionListener);
		
		mainFrame.getComboBoxSiteJoueur1().addActionListener(panelTactiquesActionListener);
		mainFrame.getComboBoxSiteJoueur2().addActionListener(panelTactiquesActionListener);
		
		mainFrame.getBtnTactiqueSauvegarder().addActionListener(panelTactiquesActionListener);
		
		//panelLineupActionListener
		mainFrame.getComboBoxLineUpPlayer1().addActionListener(panelLineupActionListener);
		mainFrame.getComboBoxLineUpPlayer2().addActionListener(panelLineupActionListener);
		mainFrame.getComboBoxLineUpPlayer3().addActionListener(panelLineupActionListener);
		mainFrame.getComboBoxLineUpPlayer4().addActionListener(panelLineupActionListener);
		mainFrame.getComboBoxLineUpPlayer5().addActionListener(panelLineupActionListener);
		
		mainFrame.getBtnSauvegarderLineUp().addActionListener(panelLineupActionListener);
		
		//panelAgendaActionListener
		//mainFrame.getBtnPanelAgendaLancer().addActionListener(panelAgendaActionListener);
		
		//panelSouthActionListener
		mainFrame.getBtnContinue().addActionListener(panelSouthActionListener);
	}
}
