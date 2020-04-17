package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.GameData;
import modele.Observer;

import java.awt.BorderLayout;

public class PanelMessagerie extends JPanel implements Observer {
	private PanelMessagerieListe panelMessagerieListe;
	private PanelMessagerieDetail panelMessagerieDetail;

	/**
	 * Create the panel.
	 */
	public PanelMessagerie() {
		setBorder(new TitledBorder(null, "Messagerie", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		panelMessagerieListe = new PanelMessagerieListe();
		add(panelMessagerieListe, BorderLayout.WEST);
		
		panelMessagerieDetail = new PanelMessagerieDetail();
		add(panelMessagerieDetail, BorderLayout.CENTER);

	}

	@Override
	public void update(GameData gameData) 
	{
		panelMessagerieListe.update(gameData);
	}
	public PanelMessagerieDetail getPanelMessagerieDetail() {
		return panelMessagerieDetail;
	}
}
