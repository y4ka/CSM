package modele;

import java.util.ArrayList;

public class Messagerie 
{
	private ArrayList<EMail> messagerie = new ArrayList<EMail>();
	
	public Messagerie()
	{
		
	}
	
	public void addEmail(EMail email)
	{
		messagerie.add(email);
	}
	
	public ArrayList<EMail> getAllMessages()
	{
		return messagerie;
	}
	
	public int getNumberNewMessages()
	{
		int newMessages = 0;
		for (EMail email : messagerie)
		{
			if (!email.isRead())
			{
				newMessages++;
			}
		}
		return newMessages;
	}
}
