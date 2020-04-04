package controller.listeners;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import generated.MainFrame;
import modele.GameData;

public class PanelEquipeMouseListener implements MouseListener {

	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	int selectedPlayer = 1;
	
	public PanelEquipeMouseListener(GameData gameData, MainFrame mainFrame)
	{
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("HEIL HITLER");
//		// TODO Auto-generated method stub
//		
//		unselectAllPlayers();
//		
//		if (e.getSource().equals(mainFrame.getPanelJoueur1()) || e.getSource().equals(mainFrame.getLabelNicknameJoueur1()))
//		{
//			for (int i = 0 ; i < mainFrame.getPanelJoueur1().getComponents().length ; i++)
//			{
//				mainFrame.getPanelJoueur1().getComponents()[i].setBackground(Color.GRAY);
//			}
//			mainFrame.getPanelJoueur1().setBackground(Color.GRAY);
//		}
//		else if (e.getSource().equals(mainFrame.getPanelJoueur2()) || e.getSource().equals(mainFrame.getLabelNicknameJoueur2()))
//		{
//			for (int i = 0 ; i < mainFrame.getPanelJoueur1().getComponents().length ; i++)
//			{
//				mainFrame.getPanelJoueur2().getComponents()[i].setBackground(Color.GRAY);
//			}
//			mainFrame.getPanelJoueur2().setBackground(Color.GRAY);
//		}
//		else if (e.getSource().equals(mainFrame.getPanelJoueur3()) || e.getSource().equals(mainFrame.getLabelNicknameJoueur3()))
//		{
//			for (int i = 0 ; i < mainFrame.getPanelJoueur1().getComponents().length ; i++)
//			{
//				mainFrame.getPanelJoueur3().getComponents()[i].setBackground(Color.GRAY);
//			}
//			mainFrame.getPanelJoueur3().setBackground(Color.GRAY);
//		}
//		else if (e.getSource().equals(mainFrame.getPanelJoueur4()) || e.getSource().equals(mainFrame.getLabelNicknameJoueur4()))
//		{
//			for (int i = 0 ; i < mainFrame.getPanelJoueur1().getComponents().length ; i++)
//			{
//				mainFrame.getPanelJoueur4().getComponents()[i].setBackground(Color.GRAY);
//			}
//			mainFrame.getPanelJoueur4().setBackground(Color.GRAY);
//		}
//		else if (e.getSource().equals(mainFrame.getPanelJoueur5()) || e.getSource().equals(mainFrame.getLabelNicknameJoueur5()))
//		{
//			for (int i = 0 ; i < mainFrame.getPanelJoueur1().getComponents().length ; i++)
//			{
//				mainFrame.getPanelJoueur5().getComponents()[i].setBackground(Color.GRAY);
//			}
//			mainFrame.getPanelJoueur5().setBackground(Color.GRAY);
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void unselectAllPlayers()
	{
//		for (int i = 0 ; i < mainFrame.getPanelJoueurs().getComponents().length ; i++)
//		{
//			JPanel jpanelJoueur = (JPanel) mainFrame.getPanelJoueurs().getComponents()[i];
//			for (int j = 0 ; j < jpanelJoueur.getComponents().length ; j++)
//			{
//				jpanelJoueur.getComponents()[j].setBackground(Color.LIGHT_GRAY);
//			}
//			jpanelJoueur.setBackground(Color.LIGHT_GRAY);
//		}
	}

}
