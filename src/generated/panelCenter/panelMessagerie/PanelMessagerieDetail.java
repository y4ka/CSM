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
	private EMail currentMail;

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
		this.currentMail = selectedEMail;
		
		//Titre du message:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle(selectedEMail.getTitle());
		
		//Contenu du message:
		textAreaContenuMessage.setText(selectedEMail.getContent());
		
		//Type du message:
		if (selectedEMail.getEmailType().equals(EMail.EMAIL_TYPE.INFORMATION))
			panelMessagerieDetailActions.setVisible(false);
		else
			panelMessagerieDetailActions.setVisible(true);
		
		//Repaint pour prendre en compte le changement du titledborder:
		this.repaint();
	}
	
	public PanelMessagerieDetailActions getPanelMessagerieDetailActions() {
		return panelMessagerieDetailActions;
	}

	public EMail getCurrentMail() {
		return currentMail;
	}
}
