package generated.panelCenter.panelEffectif;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Player;

public class PanelEffectifDataModel extends AbstractTableModel 
{

	List<Player> playerList = new ArrayList<Player>();
	String[] columnNames = {"Joueur","Poste","Rating"};
	
	@Override
	public int getRowCount() 
	{
		return playerList.size();
	}

	@Override
	public int getColumnCount() 
	{
		return 3;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) 
	{
		//Joueur
		if (columnIndex == 0)
		{
			return playerList.get(rowIndex).getNickname();
		}
		
		//Poste
		else if(columnIndex == 1)
		{
			return "Poste";
		}
		
		//Rating
		else if (columnIndex == 2)
		{
			return playerList.get(rowIndex).getRating()+"";
		}
		return "Unknown Column";
	}
	
	@Override
	public String getColumnName(int col) 
	{
	      return columnNames[col];
	}

	public void addRow(Player player)
	{
		playerList.add(player);
	}

	public void setRowCount(int i) 
	{
		playerList.clear();
	}
	
	public Player getSelectedPlayer(int selectedRow)
	{
		return playerList.get(selectedRow);
	}
}
