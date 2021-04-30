package generated.panelCenter.panelMatch;

import javax.swing.JPanel;

import modele.InGamePlayer;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PanelMatchEquipeJoueurDetails extends JPanel {
	private JLabel lblNickname;
	private JPanel panelInf;
	private JPanel panelSup;
	private JLabel lblHp;
	private JLabel lblDeath;
	private JLabel lblMoney;
	private JLabel lblKill;
	public PanelMatchEquipeJoueurDetails() {
		setOpaque(false);
		setLayout(new GridLayout(2, 1, 0, 0));
		
		panelSup = new JPanel();
		panelSup.setOpaque(false);
		add(panelSup);
		panelSup.setLayout(new GridLayout(0, 8, 0, 0));
		
		lblHp = new JLabel("HP");
		panelSup.add(lblHp);
		
		lblNickname = new JLabel("Nickname");
		panelSup.add(lblNickname);
		
		panelInf = new JPanel();
		add(panelInf);
		panelInf.setLayout(new GridLayout(0, 8, 0, 0));
		
		lblMoney = new JLabel("Money");
		panelInf.add(lblMoney);
		
		lblKill = new JLabel("Kill");
		panelInf.add(lblKill);
		
		lblDeath = new JLabel("Death");
		panelInf.add(lblDeath);
	}
	
	public void update(InGamePlayer inGamePlayer)
	{
		lblNickname.setText(inGamePlayer.getNickname());
		lblHp.setText(""+inGamePlayer.getHP());
		lblMoney.setText(inGamePlayer.getMoney()+"$");
		lblDeath.setText("D: "+inGamePlayer.getDeath());
		lblKill.setText("K: "+inGamePlayer.getKill());
	}
}
