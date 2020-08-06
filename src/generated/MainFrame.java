package generated;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import generated.panelCenter.panelAgenda.PanelAgenda;
import generated.panelCenter.panelEffectif.PanelEffectif;
import generated.panelCenter.panelMessagerie.PanelMessagerie;
import generated.panelCenter.panelPresentationMatch.PanelPresentationMatch;
import generated.panelCenter.panelMatch.PanelMatch;
import java.awt.Frame;
import generated.panelCenter.panelRanking.PanelRanking;

public class MainFrame {

	private JFrame frmCsgoManager;
	private JPanel panelCenter;
	private JPanel panelBudget;
	private JPanel panelEntrainement;
	private JPanel panelTactiques;
	private JPanel panelTactiqueJoueur1;
	private Label labelNickNameTactiqueJoueur1;
	private JComboBox comboBoxTactiqueJoueur1;
	private JComboBox comboBoxSiteJoueur1;
	private JPanel panelTactiqueJoueur2;
	private Label labelNickNameJoueur2;
	private JComboBox comboBoxTactiqueJoueur2;
	private JComboBox comboBoxSiteJoueur2;
	private JPanel panelTactiqueBoutons;
	private JButton btnTactiqueSauvegarder;
	private JPanel panelSouth;
	private JButton btnContinue;
	private PanelAgenda panelAgenda;
	private PanelMenu panelMenu;
	private PanelEffectif panelEffectif;
	private PanelPresentationMatch panelPresentationMatch;
	private PanelMessagerie panelMessagerie;
	private PanelMatch panelMatch;
	private PanelRanking panelRanking;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCsgoManager = new JFrame();
		frmCsgoManager.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmCsgoManager.setTitle("CS:GO Manager 2020");
		frmCsgoManager.setBounds(100, 100, 650, 450);
		frmCsgoManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCsgoManager.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelCenter = new JPanel();
		frmCsgoManager.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new CardLayout(0, 0));
		
		panelAgenda = new PanelAgenda();
		panelCenter.add(panelAgenda, "panelAgenda");
		
		panelMessagerie = new PanelMessagerie();
		panelCenter.add(panelMessagerie, "panelMessagerie");
		
		panelBudget = new JPanel();
		panelBudget.setBorder(new TitledBorder(null, "Budget", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelBudget, "panelBudget");
		
		panelEntrainement = new JPanel();
		panelEntrainement.setBorder(new TitledBorder(null, "Entrainement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelEntrainement, "panelEntrainement");
		
		panelTactiques = new JPanel();
		panelTactiques.setBorder(new TitledBorder(null, "Tactiques", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelTactiques, "panelTactiques");
		panelTactiques.setLayout(new BoxLayout(panelTactiques, BoxLayout.Y_AXIS));
		
		panelTactiqueJoueur1 = new JPanel();
		panelTactiques.add(panelTactiqueJoueur1);
		
		labelNickNameTactiqueJoueur1 = new Label("Vide");
		panelTactiqueJoueur1.add(labelNickNameTactiqueJoueur1);
		
		comboBoxTactiqueJoueur1 = new JComboBox();
		comboBoxTactiqueJoueur1.setModel(new DefaultComboBoxModel(new String[] {"EXECUTE", "CONTROL", "PICK", "RUSH", "FAKE"}));
		panelTactiqueJoueur1.add(comboBoxTactiqueJoueur1);
		
		comboBoxSiteJoueur1 = new JComboBox();
		comboBoxSiteJoueur1.setModel(new DefaultComboBoxModel(new String[] {"A", "MID", "B"}));
		panelTactiqueJoueur1.add(comboBoxSiteJoueur1);
		
		panelTactiqueJoueur2 = new JPanel();
		panelTactiques.add(panelTactiqueJoueur2);
		
		labelNickNameJoueur2 = new Label("Vide");
		panelTactiqueJoueur2.add(labelNickNameJoueur2);
		
		comboBoxTactiqueJoueur2 = new JComboBox();
		comboBoxTactiqueJoueur2.setModel(new DefaultComboBoxModel(new String[] {"EXECUTE", "CONTROL", "PICK", "RUSH", "FAKE"}));
		panelTactiqueJoueur2.add(comboBoxTactiqueJoueur2);
		
		comboBoxSiteJoueur2 = new JComboBox();
		comboBoxSiteJoueur2.setModel(new DefaultComboBoxModel(new String[] {"A", "MID", "B"}));
		panelTactiqueJoueur2.add(comboBoxSiteJoueur2);
		
		panelTactiqueBoutons = new JPanel();
		panelTactiques.add(panelTactiqueBoutons);
		
		btnTactiqueSauvegarder = new JButton("Sauvegarder");
		panelTactiqueBoutons.add(btnTactiqueSauvegarder);
		
		panelEffectif = new PanelEffectif();
		panelCenter.add(panelEffectif, "panelEffectif");
		
		panelPresentationMatch = new PanelPresentationMatch();
		panelCenter.add(panelPresentationMatch, "panelPresentationMatch");
		
		panelMatch = new PanelMatch();
		panelCenter.add(panelMatch, "panelMatch");
		
		panelRanking = new PanelRanking();
		panelCenter.add(panelRanking, "panelRanking");
		
		panelSouth = new JPanel();
		frmCsgoManager.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new BorderLayout(0, 0));
		
		btnContinue = new JButton("Continuer");
		panelSouth.add(btnContinue, BorderLayout.EAST);
		
		panelMenu = new PanelMenu();
		frmCsgoManager.getContentPane().add(panelMenu, BorderLayout.WEST);
	}

	public JFrame getFrame() {
		return frmCsgoManager;
	}
	public JPanel getPanelCenter() {
		return panelCenter;
	}
	
	public JComboBox getComboBoxTactiqueJoueur1() {
		return comboBoxTactiqueJoueur1;
	}
	public JComboBox getComboBoxSiteJoueur2() {
		return comboBoxSiteJoueur2;
	}
	public JComboBox getComboBoxSiteJoueur1() {
		return comboBoxSiteJoueur1;
	}
	public JComboBox getComboBoxTactiqueJoueur2() {
		return comboBoxTactiqueJoueur2;
	}
	public JButton getBtnTactiqueSauvegarder() {
		return btnTactiqueSauvegarder;
	}
	public JButton getBtnContinue() {
		return btnContinue;
	}
	public PanelMenu getPanelMenu() {
		return panelMenu;
	}
	public PanelAgenda getPanelAgenda() {
		return panelAgenda;
	}
	public PanelEffectif getPanelEffectif() {
		return panelEffectif;
	}
	public PanelPresentationMatch getPanelPresentationMatch() {
		return panelPresentationMatch;
	}
	public PanelMessagerie getPanelMessagerie() {
		return panelMessagerie;
	}
	public PanelMatch getPanelMatch() {
		return panelMatch;
	}
	public PanelRanking getPanelRanking() {
		return panelRanking;
	}	
}
