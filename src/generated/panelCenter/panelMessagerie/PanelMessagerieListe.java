package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

import modele.EMail;
import modele.GameData;
import modele.Observer;

public class PanelMessagerieListe extends JPanel implements Observer {
	private JList listMessages;
	private DefaultListModel<String> listModel;

	/**
	 * Create the panel.
	 */
	public PanelMessagerieListe() {
		setBorder(new TitledBorder(null, "Boite de Reception", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		listMessages = new JList();

		listModel = new DefaultListModel<String>();
		listMessages.setModel(listModel);

		add(listMessages);

	}

	@Override
	public void update(GameData gameData) 
	{
		listMessages.removeAll(); //TODO on ne peut pas faire de removeall ou on va perdre la selection.
		
		//Affichage du nombre de message non lus:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle("Inbox ("+gameData.getMessagerie().getNumberNewMessages()+")");
		
		//Affichage des messages dans la liste:
		DefaultListModel<String> model = (DefaultListModel<String>) listMessages.getModel();
		
		for (EMail email : gameData.getMessagerie().getAllMessages())
		{
			model.addElement(email.getTitle());
		}
		
		
	}
}
