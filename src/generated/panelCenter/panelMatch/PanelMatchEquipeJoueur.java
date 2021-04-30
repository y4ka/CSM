package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.InGamePlayer;
import modele.InGameTeam.SIDE;
import tools.ImageTools;

import javax.swing.JProgressBar;
import javax.swing.OverlayLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class PanelMatchEquipeJoueur extends JPanel {
	
	private JProgressBar progressBarHP;
	private PanelMatchEquipeJoueurDetails panelDetailsJoueur = new PanelMatchEquipeJoueurDetails();

	/**
	 * Create the panel.
	 */
	public PanelMatchEquipeJoueur() {
		setBorder(new TitledBorder(null, "<Nickname joueur>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		progressBarHP = new JProgressBar();
		progressBarHP.setValue(100);
		add(progressBarHP, BorderLayout.CENTER);

		LayoutManager overlayLayout = new OverlayLayout(progressBarHP);
		progressBarHP.setLayout(overlayLayout);
		
		progressBarHP.add(panelDetailsJoueur);
		
		progressBarHP.setStringPainted(true);
		progressBarHP.setString("");
	}
	
	public void update(InGamePlayer inGamePlayer, SIDE teamSide)
	{
		//Nom du joueur:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(inGamePlayer.getNickname());
		
		//Points de vie:
		progressBarHP.setValue(inGamePlayer.getHP());
		
		//Mise à jour de la couleur du side:
		if (teamSide != null)
		{
			if (teamSide.equals(SIDE.T))
			{
				progressBarHP.setForeground(ImageTools.COLOR_T);
			}
			else
			{
				progressBarHP.setForeground(ImageTools.COLOR_CT);
			}
		}
				
		panelDetailsJoueur.update(inGamePlayer);
	}
}
