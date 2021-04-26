package generated.panelCenter.panelEffectif;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import modele.GameData;
import modele.Observer;
import modele.Player;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelEffectifDetails extends JPanel
{
	private Player selectedPlayer;
	
	private JLabel lblPlayerImage;
	private JLabel lblName;
	private JLabel lblNickname;
	private JLabel lblAge;
	private JLabel lblCurrentTeam;
	private JPanel panelBio;
	private JPanel panelStats;
	
	public PanelEffectifDetails() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new BorderLayout(0, 0));
		
		panelBio = new JPanel();
		add(panelBio, BorderLayout.NORTH);
		GridBagLayout gbl_panelBio = new GridBagLayout();
		gbl_panelBio.columnWidths = new int[]{111, 111, 111, 111, 0};
		gbl_panelBio.rowHeights = new int[]{14, 0, 0, 0, 0};
		gbl_panelBio.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBio.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBio.setLayout(gbl_panelBio);
		
		lblPlayerImage = new JLabel("");
		GridBagConstraints gbc_lblPlayerImage = new GridBagConstraints();
		gbc_lblPlayerImage.gridheight = 4;
		gbc_lblPlayerImage.fill = GridBagConstraints.BOTH;
		gbc_lblPlayerImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerImage.gridx = 0;
		gbc_lblPlayerImage.gridy = 0;
		panelBio.add(lblPlayerImage, gbc_lblPlayerImage);
		
		lblName = new JLabel("Name: <Prenom Nom>");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		panelBio.add(lblName, gbc_lblName);
		
		lblNickname = new JLabel("Nickname: <Nickname>");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.fill = GridBagConstraints.BOTH;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 0;
		panelBio.add(lblNickname, gbc_lblNickname);
		
		lblAge = new JLabel("Age: <Age>");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.fill = GridBagConstraints.BOTH;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 2;
		panelBio.add(lblAge, gbc_lblAge);
		
		lblCurrentTeam = new JLabel("Current Team: <CurrentTeam>");
		GridBagConstraints gbc_lblCurrentTeam = new GridBagConstraints();
		gbc_lblCurrentTeam.insets = new Insets(0, 0, 0, 5);
		gbc_lblCurrentTeam.fill = GridBagConstraints.BOTH;
		gbc_lblCurrentTeam.gridx = 1;
		gbc_lblCurrentTeam.gridy = 3;
		panelBio.add(lblCurrentTeam, gbc_lblCurrentTeam);
		
		panelStats = new JPanel();
		add(panelStats);
	}

	public void update(Player selectedPlayer) 
	{
		lblName.setText("Name: "+selectedPlayer.getPrenom()+" "+selectedPlayer.getNom());
		lblNickname.setText("Nickname: "+selectedPlayer.getNickname());
		lblAge.setText("Age: ");
		lblCurrentTeam.setText("Current Team: ");
		lblPlayerImage.setIcon(selectedPlayer.getImage());
	}
}
