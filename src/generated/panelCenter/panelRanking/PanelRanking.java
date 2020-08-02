package generated.panelCenter.panelRanking;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.GameData;
import modele.Team;

public class PanelRanking extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelRanking() {
		setBorder(new TitledBorder(null, "Ranking", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

	public void update(GameData gameData)
	{
		int rank = 1;
		for (Team team : gameData.getTeamRanking())
		{
			PanelRankingTeam panelRankingTeam = new PanelRankingTeam();
			panelRankingTeam.update(team, rank);
			this.add(panelRankingTeam);
			rank++;
		}
	}
}
