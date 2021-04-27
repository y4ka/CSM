package controller;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.listeners.PanelMatchActionListener;
import controller.listeners.PanelMenuActionListener;
import controller.listeners.PanelMessagerieActionListener;
import controller.listeners.PanelSouthActionListener;
import controller.managers.GameLoop;
import controller.managers.GameManager;
import generated.MainFrame;
import modele.GameData;

public class Controller {
	
	//MVC
	GameData gameData;
	MainFrame mainFrame;
	
	//Listeners
	PanelMenuActionListener panelMenuActionListener;
	PanelSouthActionListener panelSouthActionListener;
	PanelMatchActionListener panelMatchActionListener;
	PanelMessagerieActionListener panelMessagerieActionListener;
	
	//Managers
	GameManager gameManager;
	
	public Controller(GameData gameData, MainFrame mainFrame) {
		
		//MVC
		this.gameData = gameData;
		this.mainFrame = mainFrame;
		
		//Listeners
		this.panelMenuActionListener = new PanelMenuActionListener(gameData, mainFrame);
		this.panelSouthActionListener = new PanelSouthActionListener(gameData, mainFrame);
		this.panelMatchActionListener = new PanelMatchActionListener(gameData, mainFrame);
		this.panelMessagerieActionListener = new PanelMessagerieActionListener(gameData, mainFrame);
		
		//Managers
		gameManager = new GameManager(gameData, mainFrame);
		panelSouthActionListener.addGameManager(gameManager);
		panelMessagerieActionListener.addGameManager(gameManager);
	}
	
	public void initController() {
		
		//panelMenuActionListener
		addActionListenerToAll(mainFrame.getPanelMenu(), panelMenuActionListener);
		
		//panelMatchActionListener
		mainFrame.getPanelMatch().getPanelMatchActions().getBtnStart().addActionListener(panelMatchActionListener);
		
		//panelSouthActionListener
		mainFrame.getBtnContinue().addActionListener(panelSouthActionListener);
		
		//panelMessagerieActionListener
		addActionListenerToAll(mainFrame.getPanelMessagerie().getPanelMessagerieDetail().getPanelMessagerieDetailActions(), panelMessagerieActionListener);
	}
	
	private void addActionListenerToAll(JPanel jpanel, ActionListener listener)
	{
		for (Component c : jpanel.getComponents())
		{
            if (c.getClass() == JButton.class)
            {
                JButton b = (JButton) c;
                b.addActionListener(listener);
            }
        }
	}
	
	public void nouvellePartie() {
		gameManager.nouvellePartie();
	}
}
