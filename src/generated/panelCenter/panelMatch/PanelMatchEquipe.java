package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;
import modele.InGamePlayer;
import modele.InGameTeam;
import modele.InGameTeam.SIDE;

import java.awt.Color;
import java.awt.GridLayout;

public class PanelMatchEquipe extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMatchEquipe() {
		setBorder(new TitledBorder(null, "<Nom Equipe>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));

	}

	public void update(InGameTeam team) 
	{
		//Mise à jour du nom de l'equipe:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(team.getName());
		
		//Mise à jour de la couleur du side:
		if (team.getSide() != null)
		{
			if (team.getSide().equals(SIDE.T))
				this.setBackground(new Color(196,173,110));
			else
				this.setBackground(new Color(74,117,181));
		}
		
		//Mise à joueur des joueurs:
		this.removeAll();
		
		InGamePlayer[] players = team.getInGamePlayers();
		for (int i = 0 ; i < players.length ; i++)
		{
			PanelMatchEquipeJoueur panelMatchEquipeJoueur = new PanelMatchEquipeJoueur();
			panelMatchEquipeJoueur.update(players[i]);
			
			this.add(panelMatchEquipeJoueur);
		}
	}
}
