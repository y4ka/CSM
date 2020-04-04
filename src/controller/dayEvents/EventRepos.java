package controller.dayEvents;

public class EventRepos implements DayEvent {

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
}
