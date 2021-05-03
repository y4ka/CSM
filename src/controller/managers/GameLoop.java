package controller.managers;

import generated.MainFrame;
import modele.GameData;

public class GameLoop extends Thread 
{
	private MainFrame mainFrame;
	private GameData gameData;
	
	public GameLoop (MainFrame mainFrame, GameData gameData)
	{
		this.mainFrame = mainFrame;
		this.gameData = gameData;
	}
	
	public void run() 
	{
	    long now;
	    long updateTime;
	    long wait;

	    final int TARGET_FPS = 5;
	    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

	    while (true) 
	    {
	        now = System.nanoTime();
	        
	        //Mise à jour des vues:
	        mainFrame.update(gameData);

	        updateTime = System.nanoTime() - now;
	        wait = (OPTIMAL_TIME - updateTime) / 1000000;

	        try 
	        {
	            Thread.sleep(wait);
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}
}
