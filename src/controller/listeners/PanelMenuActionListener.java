package controller.listeners;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import generated.MainFrame;
import modele.GameData;
import modele.InGameTeam;
import modele.Player;

public class PanelMenuActionListener implements ActionListener {

	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	public PanelMenuActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if (e.getSource().equals(mainFrame.getPanelMenu().getBtnEquipe()))
		{
			this.btnEquipeEvent();
		}
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnAgenda()))
		{
			this.btnAgendaEvent();
		}
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnMessagerie()))
		{
			this.btnMessagerieEvent();
		}
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnBudget()))
		{
			this.btnBudgetEvent();
		}
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnTactiques()))
		{
			this.btnTactiquesEvent();
		}
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnLineup()))
		{
			this.btnLineupEvent();
		}
	}
	
	private void btnEquipeEvent()
	{
		//Met à jour les données du panneau Effectif:
		mainFrame.getPanelEffectif().update(gameData);
		
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelEffectif");
	}
	
	private void btnMessagerieEvent()
	{
		//Met à jour les données du panneau Messagerie:
		mainFrame.getPanelMessagerie().update(gameData);
		
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelMessagerie");
	}
	
	private void btnAgendaEvent()
	{
		//Met à jour les données du panneau Agenda:
		mainFrame.getPanelAgenda().update(gameData);
		
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelAgenda");
	}
	
	private void btnBudgetEvent()
	{
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelBudget");
	}
	
	private void btnTactiquesEvent()
	{
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelTactiques");
	}
	
	private void btnLineupEvent()
	{
		updateLineUpView();
		
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelLineUp");
	}
	
	private void updateLineUpView()
	{	
		//On nettoye les comboBox:
		mainFrame.getComboBoxLineUpPlayer1().removeAllItems();
		mainFrame.getComboBoxLineUpPlayer2().removeAllItems();
		mainFrame.getComboBoxLineUpPlayer3().removeAllItems();
		mainFrame.getComboBoxLineUpPlayer4().removeAllItems();
		mainFrame.getComboBoxLineUpPlayer5().removeAllItems();
		
		//On affiche dans chaque combo tous les joueurs possibles:
		for (int i = 0 ; i < gameData.getMonEquipe().getPlayers().length ; i++)
		{
			Player player = gameData.getMonEquipe().getPlayers()[i];
			if (player != null)
			{
				mainFrame.getComboBoxLineUpPlayer1().addItem(gameData.getMonEquipe().getPlayers()[i].getNickname());
				mainFrame.getComboBoxLineUpPlayer2().addItem(gameData.getMonEquipe().getPlayers()[i].getNickname());
				mainFrame.getComboBoxLineUpPlayer3().addItem(gameData.getMonEquipe().getPlayers()[i].getNickname());
				mainFrame.getComboBoxLineUpPlayer4().addItem(gameData.getMonEquipe().getPlayers()[i].getNickname());
				mainFrame.getComboBoxLineUpPlayer5().addItem(gameData.getMonEquipe().getPlayers()[i].getNickname());
			}
		}
		
		//Si une line-up existe deja, on l'affiche en prio:
		InGameTeam inGameTeam = gameData.getMonEquipe().getInGameTeam();
		if (inGameTeam != null)
		{
			mainFrame.getComboBoxLineUpPlayer1().setSelectedItem(inGameTeam.getInGamePlayers()[0].getNickname());
			mainFrame.getComboBoxLineUpPlayer2().setSelectedItem(inGameTeam.getInGamePlayers()[1].getNickname());
			mainFrame.getComboBoxLineUpPlayer3().setSelectedItem(inGameTeam.getInGamePlayers()[2].getNickname());
			mainFrame.getComboBoxLineUpPlayer4().setSelectedItem(inGameTeam.getInGamePlayers()[3].getNickname());
			mainFrame.getComboBoxLineUpPlayer5().setSelectedItem(inGameTeam.getInGamePlayers()[4].getNickname());
		}
	}
}
