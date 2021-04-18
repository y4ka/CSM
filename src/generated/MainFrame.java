package generated;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import generated.panelCenter.panelAgenda.PanelAgenda;
import generated.panelCenter.panelEffectif.PanelEffectif;
import generated.panelCenter.panelMatch.PanelMatch;
import generated.panelCenter.panelMessagerie.PanelMessagerie;
import generated.panelCenter.panelPresentationMatch.PanelPresentationMatch;
import generated.panelCenter.panelRanking.PanelRanking;

public class MainFrame {

	private JFrame frmCsgoManager;
	private JPanel panelCenter;
	private JPanel panelBudget;
	private JPanel panelEntrainement;
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
