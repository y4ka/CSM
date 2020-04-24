package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.InGamePlayer;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;

public class PanelMatchEquipeJoueur extends JPanel {
	private JProgressBar progressBarHP;

	/**
	 * Create the panel.
	 */
	public PanelMatchEquipeJoueur() {
		setBorder(new TitledBorder(null, "<Nickname joueur>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		progressBarHP = new JProgressBar();
		progressBarHP.setValue(100);
		add(progressBarHP);

	}
	
	public void update(InGamePlayer inGamePlayer)
	{
		//Nom du joueur:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(inGamePlayer.getNickname());
		
		//Points de vie:
		progressBarHP.setValue(inGamePlayer.getHP());
	}
}
