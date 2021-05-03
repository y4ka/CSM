package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import controller.dayEvents.Day;
import controller.dayEvents.DayEvent;
import controller.dayEvents.EventMatch;

public class Agenda 
{
	private HashMap<LocalDate, Day> agenda = new HashMap<LocalDate, Day>();
	private LocalDate currentDate = LocalDate.now();
	
	public Agenda()
	{
		
	}
	
	// === INITIALISATION ===
	
	public void initCalendar()
	{
		//On d�cide de ne pas initialiser le calendar.
		//A chaque fois qu'un getter est appel� sur l'agenda et que le jour n'existe pas, on l'ajoute.
	}
	
	public void nextDay()
	{
		currentDate = currentDate.plusDays(1);
	}
	
	// === GETTERS ====
	
	public ArrayList<DayEvent> getCurrentDayEvents()
	{
		return this.getCurrentDay().getDayEvents();
	}
	
	public DayEvent getCurrentDayActiveEvent()
	{
		return this.getCurrentDay().getActiveDayEvent();
	}
	
	public boolean isCurrentDayEventsAllFinished()
	{
		return this.getCurrentDay().isDayEventsAllFinished();
	}
	
	public Day getCurrentDay()
	{
		//Si le jour n'existe pas on l'ajoute:
		if (!agenda.containsKey(currentDate))
		{
			agenda.put(currentDate, new Day());
		}
		
		return agenda.get(currentDate);
	}
	
	public ArrayList<DayEvent> getDayEvents(LocalDate date)
	{
		return this.getDay(date).getDayEvents();
	}
	
	public Day getDay(LocalDate date)
	{
		//Si le jour n'existe pas on l'ajoute:
		if (!agenda.containsKey(date))
		{
			agenda.put(date, new Day());
		}
		
		return agenda.get(date);
	}
	
	public boolean isCurrentDate(LocalDate date)
	{
		if (date.equals(currentDate))
			return true;
		else
			return false;
	}
	
	// === SETTERS ===
	
	public void addEventToCalendar(DayEvent event, LocalDate date)
	{
		Day day = this.getDay(date);
		day.addDayEvent(event);
		
		agenda.put(date, day);
	}
	
	// === DISPLAY ===
	
	private void printCalendar() 
	{
		Set<LocalDate> keys = agenda.keySet();
		Iterator<LocalDate> itr = keys.iterator();

		while (itr.hasNext()) 
		{
			LocalDate localDate = itr.next();
			Day day = agenda.get(localDate);
			for (DayEvent dayEvent : day.getDayEvents())
			{
				System.out.println(localDate + ": " + dayEvent.getEventDescription());
			}
		}
	}
	
	public LocalDate getCurrentDate() {
		return currentDate;
	}
}
