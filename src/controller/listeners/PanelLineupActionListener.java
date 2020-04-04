package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generated.MainFrame;
import modele.GameData;
import modele.InGamePlayer;
import modele.InGameTeam;

public class PanelLineupActionListener implements ActionListener 
{	
	// MVC
	GameData gameData;
	MainFrame mainFrame;

	public PanelLineupActionListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(mainFrame.getBtnSauvegarderLineUp()))
		{
			InGameTeam inGameTeam = gameData.getMonEquipe().getInGameTeam();
			
			//Creation d'une lineup si elle n'existe pas:
			if (inGameTeam == null)
			{
				inGameTeam = new InGameTeam(gameData.getMonEquipe());
			}
			
			//On recupere les joueurs selectionnes pour le match parmis tous les joueurs:
			InGamePlayer player1 = new InGamePlayer(gameData.getMonEquipe().getPlayer(String.valueOf(mainFrame.getComboBoxLineUpPlayer1().getSelectedItem())));
			InGamePlayer player2 = new InGamePlayer(gameData.getMonEquipe().getPlayer(String.valueOf(mainFrame.getComboBoxLineUpPlayer2().getSelectedItem())));
			InGamePlayer player3 = new InGamePlayer(gameData.getMonEquipe().getPlayer(String.valueOf(mainFrame.getComboBoxLineUpPlayer3().getSelectedItem())));
			InGamePlayer player4 = new InGamePlayer(gameData.getMonEquipe().getPlayer(String.valueOf(mainFrame.getComboBoxLineUpPlayer4().getSelectedItem())));
			InGamePlayer player5 = new InGamePlayer(gameData.getMonEquipe().getPlayer(String.valueOf(mainFrame.getComboBoxLineUpPlayer5().getSelectedItem())));
			
			//On recupere les strategies selectionnees pour le match parmis toutes les strategies:
			
			//On met a jour la InGameTeam:
			inGameTeam.getInGamePlayers()[0] = player1;
			inGameTeam.getInGamePlayers()[1] = player2;
			inGameTeam.getInGamePlayers()[2] = player3;
			inGameTeam.getInGamePlayers()[3] = player4;
			inGameTeam.getInGamePlayers()[4] = player5;
			
			//On renvoie l'equipe mise a jour:
			gameData.getMonEquipe().setInGameTeam(inGameTeam);
		}
	}
}
