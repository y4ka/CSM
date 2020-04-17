package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modele.EMail;
import modele.GameData;

import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class PanelMessagerieDetail extends JPanel {
	private JTextArea textAreaContenuMessage;
	private PanelMessagerieDetailActions panelMessagerieDetailActions;

	/**
	 * Create the panel.
	 */
	public PanelMessagerieDetail() {
		setBorder(new TitledBorder(null, "<Titre email>", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		textAreaContenuMessage = new JTextArea();
		add(textAreaContenuMessage, BorderLayout.CENTER);
		
		panelMessagerieDetailActions = new PanelMessagerieDetailActions();
		add(panelMessagerieDetailActions, BorderLayout.SOUTH);
	}

	public void update(EMail selectedEMail)
	{
		//Titre du message:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(selectedEMail.getTitle());
		
		//Contenu du message:
		textAreaContenuMessage.setText(selectedEMail.getContent());
		
		//Repaint pour prendre en compte le changement du titledborder:
		this.repaint();
	}
}
