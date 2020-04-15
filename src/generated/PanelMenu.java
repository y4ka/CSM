package generated;

import javax.swing.JPanel;

import controller.listeners.PanelMenuActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenu extends JPanel {
	private JButton btnAgenda;
	private JButton btnTactiques;
	private JButton btnLineup;
	private JButton btnMessagerie;
	private JButton btnBudget;
	private JButton btnEffectif;
	
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
		
		btnTactiques = new JButton("Tactiques");
		add(btnTactiques);
		
		btnLineup = new JButton("LineUp");
		add(btnLineup);
	}

	public JButton getBtnAgenda() {
		return btnAgenda;
	}
	public JButton getBtnTactiques() {
		return btnTactiques;
	}
	public JButton getBtnLineup() {
		return btnLineup;
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
}
