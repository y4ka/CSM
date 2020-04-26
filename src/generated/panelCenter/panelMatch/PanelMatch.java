package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class PanelMatch extends JPanel {
	private PanelMatchEquipe panelMatchEquipeA;
	private PanelMatchEquipe panelMatchEquipeB;
	private PanelMatchLogs panelMatchLogs;
	private PanelMatchActions panelMatchActions;

	/**
	 * Create the panel.
	 */
	public PanelMatch() {
		setBorder(new TitledBorder(null, "Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		panelMatchActions = new PanelMatchActions();
		add(panelMatchActions);
		
		panelMatchEquipeA = new PanelMatchEquipe();
		add(panelMatchEquipeA);
		
		panelMatchLogs = new PanelMatchLogs();
		add(panelMatchLogs);
		
		panelMatchEquipeB = new PanelMatchEquipe();
		add(panelMatchEquipeB);
	}
	
	public void update(EventMatch match) 
	{
		panelMatchEquipeA.update(match.getInGameTeamA());
		panelMatchEquipeB.update(match.getInGameTeamB());
		panelMatchLogs.update(match);
		panelMatchActions.update(match);
	}
	public PanelMatchActions getPanelMatchActions() {
		return panelMatchActions;
	}
	public PanelMatchLogs getPanelMatchLogs() {
		return panelMatchLogs;
	}
	public PanelMatchEquipe getPanelMatchEquipeA() {
		return panelMatchEquipeA;
	}
	public PanelMatchEquipe getPanelMatchEquipeB() {
		return panelMatchEquipeB;
	}
}
