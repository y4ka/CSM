package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.managers.GameManager;
import generated.MainFrame;
import modele.GameData;

public class PanelSouthActionListener implements ActionListener {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Manager
	GameManager gameManager;
		
	public PanelSouthActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(mainFrame.getBtnContinue()))
		{
			gameManager.nextAction();
		}
	}
	
	public void addGameManager(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
}
