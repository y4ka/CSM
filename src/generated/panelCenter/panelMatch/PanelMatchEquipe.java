package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;
import modele.InGamePlayer;
import modele.InGameTeam;
import modele.InGameTeam.SIDE;
import tools.ImageTools;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

public class PanelMatchEquipe extends JPanel {

	private ArrayList<PanelMatchEquipeJoueur> listPanelsJoueurs = new ArrayList<PanelMatchEquipeJoueur>();
	
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
		SIDE teamSide = team.getSide();
		if (team.getSide() != null)
		{
			if (teamSide.equals(SIDE.T))
				this.setBackground(ImageTools.COLOR_T);
			else
				this.setBackground(ImageTools.COLOR_CT);
		}
		
		//Mise à joueur des joueurs:
		InGamePlayer[] players = team.getInGamePlayers();
		while (listPanelsJoueurs.size() < players.length)
		{
			PanelMatchEquipeJoueur panelMatchEquipeJoueur = new PanelMatchEquipeJoueur();
			listPanelsJoueurs.add(panelMatchEquipeJoueur);
			this.add(panelMatchEquipeJoueur);
		}
		
		for (int i = 0 ; i < players.length ; i++)
		{
			listPanelsJoueurs.get(i).update(players[i], teamSide);
		}
	}
}
