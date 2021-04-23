package controller.dayEvents;

import java.awt.Color;

public class EventRepos extends DayEvent {

	public EventRepos()
	{
		super();
	}
	
	@Override
	public void startEvent() 
	{
		System.out.println("startEvent REPOS");
	}

	@Override
	public void endEvent() 
	{
		
	}

	@Override
	public DAY_EVENTS getEventType() 
	{
		return DAY_EVENTS.REPOS;
	}

	@Override
	public String getEventDescription() {
		return "Repos";
	}
	
	@Override
	public Color getEventColor() {
		return Color.GREEN;
	}
}
