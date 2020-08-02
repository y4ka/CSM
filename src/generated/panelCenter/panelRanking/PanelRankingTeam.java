package generated.panelCenter.panelRanking;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import modele.Team;

public class PanelRankingTeam extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelRankingTeam() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "#<Rank> <Team>", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

	}

	public void update(Team team, int rank)
	{
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle("#"+rank+" - "+team.getName()+" ("+team.getRankingPoints()+")");
	}
}
