package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.managers.GameManager;
import generated.MainFrame;
import generated.panelCenter.panelMessagerie.PanelMessagerie;
import generated.panelCenter.panelMessagerie.PanelMessagerieDetail;
import modele.EMail;
import modele.GameData;

public class PanelMessagerieActionListener implements ActionListener 
{
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Manager
	GameManager gameManager;
	
	public PanelMessagerieActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		PanelMessagerie panelMessagerie = mainFrame.getPanelMessagerie();
		PanelMessagerieDetail panelMessagerieDetail = panelMessagerie.getPanelMessagerieDetail();
		EMail currentMail = panelMessagerieDetail.getCurrentMail();
		
		if (e.getSource().equals(panelMessagerieDetail.getPanelMessagerieDetailActions().getBtnAccepter()))
		{
			gameManager.getEmailManager().answerAction(currentMail, true);
		}
		else if (e.getSource().equals(panelMessagerie.getPanelMessagerieDetail().getPanelMessagerieDetailActions().getBtnRefuser()))
		{
			gameManager.getEmailManager().answerAction(currentMail, false);
		}
	}
	
	public void addGameManager(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
}
