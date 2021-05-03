package controller.dayEvents;

import java.util.ArrayList;

import controller.dayEvents.DayEvent.DAY_EVENTS;
import controller.dayEvents.DayEvent.EVENT_STATUS;

public class Day 
{	
	private ArrayList<DayEvent> dayEvents = new ArrayList<DayEvent>();
	
	public Day()
	{
		
	}

	public ArrayList<DayEvent> getDayEvents() {
		return dayEvents;
	}
	
	//On renvoie le premier �v�nement qui n'est pas termin� de la journ�e:
	public DayEvent getActiveDayEvent()
	{
		if (!dayEvents.isEmpty())
		{
			for (DayEvent dayEvent : dayEvents)
			{
				if (dayEvent.getEventStatus() != EVENT_STATUS.ENDED)
					return dayEvent;
			}
		}
		
		return null;
	}
	
	public boolean isDayEventsAllFinished()
	{
		for (DayEvent dayEvent : dayEvents)
		{
			if (dayEvent.getEventStatus() != EVENT_STATUS.ENDED)
				return false;
		}
		return true;
	}

	public void addDayEvent(DayEvent newDayEvent) {
		this.dayEvents.add(newDayEvent);
	}
}
