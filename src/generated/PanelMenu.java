package generated;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private JButton btnAgenda;
	private JButton btnMessagerie;
	private JButton btnBudget;
	private JButton btnEffectif;
	private JButton btnRanking;
	
	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAgenda = new JButton("Agenda");
		add(btnAgenda);
		
		btnMessagerie = new JButton("Messagerie");
		add(btnMessagerie);
		
		btnEffectif = new JButton("Effectif");
		add(btnEffectif);
		
		btnBudget = new JButton("Budget");
		add(btnBudget);
		
		btnRanking = new JButton("Ranking");
		add(btnRanking);
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
