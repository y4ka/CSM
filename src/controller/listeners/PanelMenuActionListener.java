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
		else if (e.getSource().equals(mainFrame.getPanelMenu().getBtnRanking()))
		{
			this.btnRankingEvent();
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
	
	private void btnRankingEvent()
	{
		//Met à jour les données du panneau Ranking:
		mainFrame.getPanelRanking().update(gameData);
				
		//Affiche le panneau une fois qu'il est a jour:
		CardLayout cl = (CardLayout)(mainFrame.getPanelCenter().getLayout());
	    cl.show(mainFrame.getPanelCenter(), "panelRanking");
	}
}
