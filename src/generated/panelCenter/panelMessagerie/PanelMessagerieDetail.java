package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class PanelMessagerieDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMessagerieDetail() {
		setBorder(new TitledBorder(null, "<Titre email>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JTextArea textAreaContenuMessage = new JTextArea();
		add(textAreaContenuMessage, BorderLayout.CENTER);
		
		PanelMessagerieDetailActions panelMessagerieDetailActions = new PanelMessagerieDetailActions();
		add(panelMessagerieDetailActions, BorderLayout.SOUTH);

	}

}
