package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generated.MainFrame;
import modele.GameData;
import modele.Strategy;

public class PanelTactiquesActionListener implements ActionListener {

	//MVC
	GameData gameData;
	MainFrame mainFrame;
		
	public PanelTactiquesActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(mainFrame.getBtnTactiqueSauvegarder()))
		{	
			Strategy newStrategy = new Strategy();
			newStrategy.defautInitialisation(gameData.getMonEquipe());
			gameData.getMonEquipe().getStrategies().add(newStrategy);
		}
	}
}
