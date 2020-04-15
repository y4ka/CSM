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

public class MainFrame {

	private JFrame frame;
	private JPanel panelCenter;
	private JPanel panelBudget;
	private JPanel panelEntrainement;
	private JPanel panelMatch;
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
	private JPanel panelLineUp;
	private JButton btnSauvegarderLineUp;
	private JComboBox comboBoxLineUpPlayer1;
	private JComboBox comboBoxLineUpPlayer2;
	private JComboBox comboBoxLineUpPlayer3;
	private JComboBox comboBoxLineUpPlayer4;
	private JComboBox comboBoxLineUpPlayer5;
	private JButton btnMatchStart;
	private JPanel panelMatchTeamA;
	private JPanel panelMatchTeamB;
	private JPanel panelMatchCenter;
	private Label labelTeamAName;
	private Label labelTeamALogo;
	private JLabel labelMatchScore;
	private TextArea textAreaMatchLogs;
	private JPanel panelSouth;
	private JButton btnContinue;
	private PanelAgenda panelAgenda;
	private PanelMenu panelMenu;
	private PanelEffectif panelEffectif;
	private PanelPresentationMatch panelPresentationMatch;
	private PanelMessagerie panelMessagerie;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
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
		
		panelMatch = new JPanel();
		panelMatch.setBorder(new TitledBorder(null, "Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelMatch, "panelMatch");
		panelMatch.setLayout(new BorderLayout(0, 0));
		
		panelMatchTeamA = new JPanel();
		panelMatch.add(panelMatchTeamA, BorderLayout.WEST);
		panelMatchTeamA.setLayout(new BoxLayout(panelMatchTeamA, BoxLayout.Y_AXIS));
		
		labelTeamAName = new Label("Vide");
		panelMatchTeamA.add(labelTeamAName);
		
		labelTeamALogo = new Label("Vide");
		panelMatchTeamA.add(labelTeamALogo);
		
		panelMatchTeamB = new JPanel();
		panelMatch.add(panelMatchTeamB, BorderLayout.EAST);
		
		panelMatchCenter = new JPanel();
		panelMatch.add(panelMatchCenter);
		panelMatchCenter.setLayout(new BoxLayout(panelMatchCenter, BoxLayout.Y_AXIS));
		
		btnMatchStart = new JButton("Start");
		btnMatchStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMatchCenter.add(btnMatchStart);
		
		labelMatchScore = new JLabel("Vide");
		labelMatchScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelMatchCenter.add(labelMatchScore);
		
		textAreaMatchLogs = new TextArea();
		textAreaMatchLogs.setEditable(false);
		panelMatchCenter.add(textAreaMatchLogs);
		
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
		
		panelLineUp = new JPanel();
		panelLineUp.setBorder(new TitledBorder(null, "LineUp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelLineUp, "panelLineUp");
		panelLineUp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSauvegarderLineUp = new JButton("Sauvegarder");
		panelLineUp.add(btnSauvegarderLineUp);
		
		comboBoxLineUpPlayer1 = new JComboBox();
		panelLineUp.add(comboBoxLineUpPlayer1);
		
		comboBoxLineUpPlayer2 = new JComboBox();
		panelLineUp.add(comboBoxLineUpPlayer2);
		
		comboBoxLineUpPlayer3 = new JComboBox();
		panelLineUp.add(comboBoxLineUpPlayer3);
		
		comboBoxLineUpPlayer4 = new JComboBox();
		panelLineUp.add(comboBoxLineUpPlayer4);
		
		comboBoxLineUpPlayer5 = new JComboBox();
		panelLineUp.add(comboBoxLineUpPlayer5);
		
		panelEffectif = new PanelEffectif();
		panelCenter.add(panelEffectif, "panelEffectif");
		
		panelPresentationMatch = new PanelPresentationMatch();
		panelCenter.add(panelPresentationMatch, "panelPresentationMatch");
		
		panelSouth = new JPanel();
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new BorderLayout(0, 0));
		
		btnContinue = new JButton("Continuer");
		panelSouth.add(btnContinue, BorderLayout.EAST);
		
		panelMenu = new PanelMenu();
		frame.getContentPane().add(panelMenu, BorderLayout.WEST);
	}

	public JFrame getFrame() {
		return frame;
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
	public JButton getBtnSauvegarderLineUp() {
		return btnSauvegarderLineUp;
	}
	public JComboBox getComboBoxLineUpPlayer2() {
		return comboBoxLineUpPlayer2;
	}
	public JComboBox getComboBoxLineUpPlayer1() {
		return comboBoxLineUpPlayer1;
	}
	public JComboBox getComboBoxLineUpPlayer3() {
		return comboBoxLineUpPlayer3;
	}
	public JComboBox getComboBoxLineUpPlayer5() {
		return comboBoxLineUpPlayer5;
	}
	public JComboBox getComboBoxLineUpPlayer4() {
		return comboBoxLineUpPlayer4;
	}
	public JButton getBtnMatchStart() {
		return btnMatchStart;
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
	public JPanel getPanelLineUp() {
		return panelLineUp;
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
}
