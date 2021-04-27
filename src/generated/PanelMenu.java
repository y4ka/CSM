package generated;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

import modele.GameData;
import modele.Observer;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelMenu extends JPanel implements Observer {
	private JButton btnAgenda;
	private JButton btnMessagerie;
	private JButton btnBudget;
	private JButton btnEffectif;
	private JButton btnRanking;
	
	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{87, 0};
		gridBagLayout.rowHeights = new int[]{23, 23, 23, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnAgenda = new JButton("Agenda");
		GridBagConstraints gbc_btnAgenda = new GridBagConstraints();
		gbc_btnAgenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgenda.anchor = GridBagConstraints.WEST;
		gbc_btnAgenda.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgenda.gridx = 0;
		gbc_btnAgenda.gridy = 0;
		add(btnAgenda, gbc_btnAgenda);
		
		btnMessagerie = new JButton("Messagerie");
		GridBagConstraints gbc_btnMessagerie = new GridBagConstraints();
		gbc_btnMessagerie.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMessagerie.anchor = GridBagConstraints.WEST;
		gbc_btnMessagerie.insets = new Insets(0, 0, 5, 0);
		gbc_btnMessagerie.gridx = 0;
		gbc_btnMessagerie.gridy = 1;
		add(btnMessagerie, gbc_btnMessagerie);
		
		btnEffectif = new JButton("Effectif");
		GridBagConstraints gbc_btnEffectif = new GridBagConstraints();
		gbc_btnEffectif.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEffectif.anchor = GridBagConstraints.WEST;
		gbc_btnEffectif.insets = new Insets(0, 0, 5, 0);
		gbc_btnEffectif.gridx = 0;
		gbc_btnEffectif.gridy = 2;
		add(btnEffectif, gbc_btnEffectif);
		
		btnBudget = new JButton("Budget");
		GridBagConstraints gbc_btnBudget = new GridBagConstraints();
		gbc_btnBudget.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBudget.anchor = GridBagConstraints.WEST;
		gbc_btnBudget.insets = new Insets(0, 0, 5, 0);
		gbc_btnBudget.gridx = 0;
		gbc_btnBudget.gridy = 3;
		add(btnBudget, gbc_btnBudget);
		
		btnRanking = new JButton("Ranking");
		GridBagConstraints gbc_btnRanking = new GridBagConstraints();
		gbc_btnRanking.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRanking.anchor = GridBagConstraints.WEST;
		gbc_btnRanking.gridx = 0;
		gbc_btnRanking.gridy = 4;
		add(btnRanking, gbc_btnRanking);
	}
	
	@Override
	public void update(GameData gameData) 
	{
		int numberNewMessages = gameData.getMessagerie().getNumberNewMessages();
		if (numberNewMessages != 0)
		{
			btnMessagerie.setText("Messagerie ("+numberNewMessages+")");
		}
		else
		{
			btnMessagerie.setText("Messagerie");
		}
	}

	public JButton getBtnAgenda() {
		return btnAgenda;
	}
	public JButton getBtnMessagerie() {
		return btnMessagerie;
	}
	public JButton getBtnBudget() {
		return btnBudget;
	}
	public JButton getBtnEquipe() {
		return btnEffectif;
	}
	public JButton getBtnRanking() {
		return btnRanking;
	}
}
