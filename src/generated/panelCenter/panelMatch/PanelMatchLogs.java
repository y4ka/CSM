package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.EventMatch;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class PanelMatchLogs extends JPanel {
	private JLabel lblScore;
	private JTextArea textAreaLogs;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelMatchLogs() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Logs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		lblScore = new JLabel("Score");
		lblScore.setHorizontalTextPosition(SwingConstants.CENTER);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblScore, BorderLayout.NORTH);
		
		textAreaLogs = new JTextArea();
		scrollPane = new JScrollPane(textAreaLogs);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void update(EventMatch match) 
	{
		//Affichage du score:
		int scoreA = match.getInGameTeamA().getScore();
		int scoreB = match.getInGameTeamB().getScore();
		lblScore.setText(scoreA+" - "+scoreB);
	}
	public JTextArea getTextAreaLogs() {
		return textAreaLogs;
	}
}
