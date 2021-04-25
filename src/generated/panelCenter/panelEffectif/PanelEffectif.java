package generated.panelCenter.panelEffectif;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.GameData;
import modele.Observer;
import modele.Player;
import modele.Team;

public class PanelEffectif extends JPanel implements Observer, ListSelectionListener
{
	private PanelEffectifDataModel dataModel;
	private JScrollPane tableEffectifScrollPane;
	private JTable tableEffectif;
	private PanelEffectifDetails panelEffectifDetails;

	/**
	 * Create the panel.
	 */
	public PanelEffectif() 
	{
		setBorder(new TitledBorder(null, "Effectif", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		tableEffectif = new JTable();
		tableEffectif.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEffectif.getSelectionModel().addListSelectionListener(this);
		tableEffectif.setBounds(30,40,200,300);
		tableEffectifScrollPane = new JScrollPane(tableEffectif);    
		tableEffectifScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		dataModel = new PanelEffectifDataModel();
		tableEffectif.setModel(dataModel);
		
		add(tableEffectifScrollPane, BorderLayout.NORTH);
		
		panelEffectifDetails = new PanelEffectifDetails();
		add(panelEffectifDetails, BorderLayout.CENTER);
	}
	
	public void update(GameData gameData) 
	{
		dataModel.setRowCount(0);
		
		Team myTeam = gameData.getMonEquipe();
		for (int i = 0 ; i < myTeam.getPlayers().length ; i++)
		{
			Player player = myTeam.getPlayers()[i];
			if (player != null)
			{
				dataModel.addRow(player);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		Player selectedPlayer = dataModel.getSelectedPlayer(tableEffectif.getSelectedRow());
		panelEffectifDetails.update(selectedPlayer);
	}
}
