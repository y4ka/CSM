package controller;

import generated.MainFrame;
import modele.GameData;

public class Main 
{
	public static void main(String[] args) {
		
		// Assemble all the pieces of the MVC
		GameData gameData = new GameData();
		MainFrame mainFrame = new MainFrame();
		
		Controller controller = new Controller(gameData, mainFrame);
		controller.initController();
		controller.nouvellePartie();
		
		mainFrame.getFrame().setVisible(true);
		mainFrame.update(gameData);
	}
}
