package generated.panelCenter.panelMatch;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.dayEvents.DayEvent.EVENT_STATUS;
import controller.dayEvents.EventMatch;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class PanelMatchLogs extends JPanel {
	private JLabel lblScore;
	private JTextArea textAreaLogs;
	private JScrollPane scrollPane;
	private JLabel lblTime;

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
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTime, BorderLayout.SOUTH);
		
		textAreaLogs = new JTextArea();
		scrollPane = new JScrollPane(textAreaLogs);
		add(scrollPane);
	}

	public void update(EventMatch match) 
	{
		//Affichage du score:
		int scoreA = match.getInGameTeamA().getScore();
		int scoreB = match.getInGameTeamB().getScore();
		lblScore.setText(scoreA+" - "+scoreB);
		
		//Affiche du timer:
		int time = match.getTimeRemaining();
		int min = time/60;
		lblTime.setText(min+":"+time%60);
		
		//Si le match est terminé, on clear les logs:
		if (match.getEventStatus() == EVENT_STATUS.ENDED)
			textAreaLogs.setText("");
	}
	public JTextArea getTextAreaLogs() {
		return textAreaLogs;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}	
}
