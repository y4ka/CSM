package generated.MainPanels;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;
import modele.GameData;
import modele.Observer;

import java.awt.GridLayout;

public class PanelPresentationMatch extends JPanel {
	private PanelPresentationMatchEquipe panelPresentationMatchEquipeA;
	private PanelPresentationMatchEquipe panelPresentationMatchEquipeB;

	/**
	 * Create the panel.
	 */
	public PanelPresentationMatch() {
		setBorder(new TitledBorder(null, "Presentation Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		panelPresentationMatchEquipeA = new PanelPresentationMatchEquipe();
		add(panelPresentationMatchEquipeA);
		
		panelPresentationMatchEquipeB = new PanelPresentationMatchEquipe();
		add(panelPresentationMatchEquipeB);

	}
	
	public void update(EventMatch match) 
	{
		panelPresentationMatchEquipeA.update(match.getInGameTeamA());
		panelPresentationMatchEquipeB.update(match.getInGameTeamB());
	}
}
