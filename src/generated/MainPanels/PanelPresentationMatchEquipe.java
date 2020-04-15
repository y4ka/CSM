package generated.MainPanels;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.Team;

import javax.swing.JLabel;
import java.awt.GridLayout;

public class PanelPresentationMatchEquipe extends JPanel {
	private JLabel lblPlayer5;
	private JLabel lblPlayer4;
	private JLabel lblPlayer3;
	private JLabel lblPlayer2;
	private JLabel lblPlayer1;

	/**
	 * Create the panel.
	 */
	public PanelPresentationMatchEquipe() {
		setBorder(new TitledBorder(null, "<Team Name>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblPlayer1 = new JLabel("Player 1");
		add(lblPlayer1);
		
		lblPlayer2 = new JLabel("Player 2");
		add(lblPlayer2);
		
		lblPlayer3 = new JLabel("Player 3");
		add(lblPlayer3);
		
		lblPlayer4 = new JLabel("Player 4");
		add(lblPlayer4);
		
		lblPlayer5 = new JLabel("Player 5");
		add(lblPlayer5);

	}

	public void update(Team team)
	{
		//Affichage nom equipe:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(team.getName());
		
		//Affichage joueurs:
		for (int i = 0 ; i < team.getPlayers().length ; i++)
		{
			switch (i)
			{
			case 0:
				lblPlayer1.setText(team.getPlayers()[i].getNickname());
				break;
			case 1:
				lblPlayer2.setText(team.getPlayers()[i].getNickname());
				break;
			case 2:
				lblPlayer3.setText(team.getPlayers()[i].getNickname());
				break;
			case 3:
				lblPlayer4.setText(team.getPlayers()[i].getNickname());
				break;
			case 4:
				lblPlayer5.setText(team.getPlayers()[i].getNickname());
				break;
			}
		}
	}
}
