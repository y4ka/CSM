package controller.dayEvents;

public class Day 
{	
	private DayEvent dayEvent = new EventRepos();
	
	public Day()
	{
		
	}

	public DayEvent getDayEvent() {
		return dayEvent;
	}

	public void setDayEvent(DayEvent dayEvent) {
		this.dayEvent = dayEvent;
	}
}
