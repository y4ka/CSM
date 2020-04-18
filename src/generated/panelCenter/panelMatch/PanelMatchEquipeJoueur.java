package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.InGamePlayer;

public class PanelMatchEquipeJoueur extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMatchEquipeJoueur() {
		setBorder(new TitledBorder(null, "<Nickname joueur>", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	}
	
	public void update(InGamePlayer inGamePlayer)
	{
		//Mise à jour du nom de l'equipe:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(inGamePlayer.getNickname());
	}
}
