package generated.MainPanels;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.GameData;
import modele.Player;
import modele.Team;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class PanelEquipeListe extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEquipeListe() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}

	public void update(Team myTeam, GameData gameData)
	{
		//On supprime les PanelEquipeListeJoueur existants:
		this.removeAll();
		
		//On crée les PanelEquipeListeJoueur:
		for (int i = 0 ; i < myTeam.getPlayers().length ; i++)
		{
			PanelEquipeListeJoueur panelEquipeListeJoueur = new PanelEquipeListeJoueur();
			add(panelEquipeListeJoueur);
			
			Player player = gameData.getMyPlayer(i);
			panelEquipeListeJoueur.update(player);
		}
	}
}
