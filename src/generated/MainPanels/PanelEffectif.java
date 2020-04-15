package generated.MainPanels;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import modele.GameData;
import modele.Observable;
import modele.Observer;
import modele.Player;
import modele.Team;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelEffectif extends JPanel implements Observer{

	private DefaultTableModel dataModel;
	private JScrollPane tableEffectifScrollPane;
	private JTable tableEffectif;

	/**
	 * Create the panel.
	 */
	public PanelEffectif() 
	{
		setBorder(new TitledBorder(null, "Effectif", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		tableEffectif = new JTable();    
		tableEffectif.setBounds(30,40,200,300);          
		tableEffectifScrollPane = new JScrollPane(tableEffectif);    
		tableEffectifScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		dataModel = new DefaultTableModel();
		dataModel.addColumn("Joueur");
		dataModel.addColumn("Poste");
		dataModel.addColumn("Rating");
		
		tableEffectif.setModel(dataModel);
		
		add(tableEffectifScrollPane);
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
				String data[]={player.getNickname(),"",""+player.getRating()};
				dataModel.addRow(data);
			}
		}
	}
}
