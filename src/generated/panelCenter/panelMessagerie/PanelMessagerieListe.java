package generated.panelCenter.panelMessagerie;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.EMail;
import modele.GameData;
import modele.Observer;

public class PanelMessagerieListe extends JPanel implements Observer, ListSelectionListener {
	private JList listMessages;
	private DefaultListModel<EMail> listModel;

	/**
	 * Create the panel.
	 */
	public PanelMessagerieListe() {
		setBorder(new TitledBorder(null, "Boite de Reception", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		listMessages = new JList();

		//Modele:
		listModel = new DefaultListModel<EMail>();
		listMessages.setModel(listModel);
		
		//Selection Model:
		ListSelectionModel listSelectionModel = listMessages.getSelectionModel();
		listSelectionModel.addListSelectionListener(this);
	    listMessages.setSelectionModel(listSelectionModel);

		add(listMessages);
	}

	@Override
	public void update(GameData gameData) 
	{
		//Affichage du nombre de message non lus:
		TitledBorder titledBorder = (TitledBorder) this.getBorder();
		titledBorder.setTitle("Inbox ("+gameData.getMessagerie().getNumberNewMessages()+")");
		
		//Affichage des messages dans la liste:
		DefaultListModel<EMail> model = (DefaultListModel<EMail>) listMessages.getModel();
		
		for (EMail email : gameData.getMessagerie().getAllMessages())
		{
			//Si l'email n'est pas deja dans la liste on l'ajoute:
			if (!model.contains(email))
			{
				model.addElement(email);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		EMail selectedEMail = (EMail) listModel.getElementAt(listMessages.getSelectedIndex());
		System.out.println(selectedEMail.getTitle());
		
		PanelMessagerie panelMessagerie = (PanelMessagerie)this.getParent();
		panelMessagerie.getPanelMessagerieDetail().update(selectedEMail);
	}
}
