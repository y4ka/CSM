package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;
import controller.dayEvents.DayEvent.DAY_EVENTS;
import modele.GameData;
import modele.Observer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class PanelMatch extends JPanel implements Observer {
	private PanelMatchEquipe panelMatchEquipeA;
	private PanelMatchEquipe panelMatchEquipeB;
	private PanelMatchLogs panelMatchLogs;
	private PanelMatchActions panelMatchActions;

	/**
	 * Create the panel.
	 */
	public PanelMatch() {
		setBorder(new TitledBorder(null, "Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, 146, 146, 0};
		gridBagLayout.rowHeights = new int[]{139, 139, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelMatchActions = new PanelMatchActions();
		GridBagConstraints gbc_panelMatchActions = new GridBagConstraints();
		gbc_panelMatchActions.weighty = 1.0;
		gbc_panelMatchActions.weightx = 1.0;
		gbc_panelMatchActions.fill = GridBagConstraints.BOTH;
		gbc_panelMatchActions.insets = new Insets(0, 0, 5, 5);
		gbc_panelMatchActions.gridx = 1;
		gbc_panelMatchActions.gridy = 0;
		add(panelMatchActions, gbc_panelMatchActions);
		
		panelMatchEquipeA = new PanelMatchEquipe();
		GridBagConstraints gbc_panelMatchEquipeA = new GridBagConstraints();
		gbc_panelMatchEquipeA.weighty = 1.0;
		gbc_panelMatchEquipeA.weightx = 1.0;
		gbc_panelMatchEquipeA.fill = GridBagConstraints.BOTH;
		gbc_panelMatchEquipeA.insets = new Insets(0, 0, 5, 5);
		gbc_panelMatchEquipeA.gridx = 0;
		gbc_panelMatchEquipeA.gridy = 0;
		add(panelMatchEquipeA, gbc_panelMatchEquipeA);
		
		panelMatchLogs = new PanelMatchLogs();
		GridBagConstraints gbc_panelMatchLogs = new GridBagConstraints();
		gbc_panelMatchLogs.weighty = 1.0;
		gbc_panelMatchLogs.weightx = 1.0;
		gbc_panelMatchLogs.gridwidth = 3;
		gbc_panelMatchLogs.fill = GridBagConstraints.BOTH;
		gbc_panelMatchLogs.insets = new Insets(0, 0, 5, 0);
		gbc_panelMatchLogs.gridx = 0;
		gbc_panelMatchLogs.gridy = 1;
		add(panelMatchLogs, gbc_panelMatchLogs);
		
		panelMatchEquipeB = new PanelMatchEquipe();
		GridBagConstraints gbc_panelMatchEquipeB = new GridBagConstraints();
		gbc_panelMatchEquipeB.weighty = 1.0;
		gbc_panelMatchEquipeB.weightx = 1.0;
		gbc_panelMatchEquipeB.fill = GridBagConstraints.BOTH;
		gbc_panelMatchEquipeB.insets = new Insets(0, 0, 0, 5);
		gbc_panelMatchEquipeB.gridx = 2;
		gbc_panelMatchEquipeB.gridy = 0;
		add(panelMatchEquipeB, gbc_panelMatchEquipeB);
	}
	
	@Override
	public void update(GameData gameData) 
	{
		DayEvent currentDayEvent = gameData.getAgenda().getCurrentDayActiveEvent();
		if (currentDayEvent != null && currentDayEvent.getEventType() == DAY_EVENTS.MATCH)
		{
			EventMatch currentMatch = (EventMatch) currentDayEvent;
			panelMatchEquipeA.update(currentMatch.getInGameTeamA());
			panelMatchEquipeB.update(currentMatch.getInGameTeamB());
			panelMatchLogs.update(currentMatch);
			panelMatchActions.update(currentMatch);
		}
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
