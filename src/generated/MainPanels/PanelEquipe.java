package generated.MainPanels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modele.GameData;
import modele.Observer;

public class PanelEquipe extends JPanel implements Observer {
	
	private PanelEquipeListe panelEquipeListe;
	private PanelEquipeDetail panelEquipeDetail;

	/**
	 * Create the panel.
	 */
	public PanelEquipe() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		panelEquipeListe = new PanelEquipeListe();
		panelEquipeListe.setBorder(new TitledBorder(null, "<Team>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelEquipeListe, BorderLayout.NORTH);
		
		panelEquipeDetail = new PanelEquipeDetail();
		panelEquipeDetail.setBorder(new TitledBorder(null, "<Nickname>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelEquipeDetail, BorderLayout.CENTER);

	}

	public void update(GameData gameData) 
	{
		//On met à jour la liste des joueurs:
		panelEquipeListe.update(gameData.getMonEquipe(), gameData); //TODO ca fait chier de passer un gamedata, on ne devrait passer que l'équipe
		
		//On met à jour le titre du panel:
		TitledBorder titledBorder = (TitledBorder) panelEquipeListe.getBorder();
		titledBorder.setTitle(gameData.getMonEquipe().getName());
	}
}
