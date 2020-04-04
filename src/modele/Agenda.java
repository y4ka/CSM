package modele;

import java.time.LocalDate;
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
		//On décide de ne pas initialiser le calendar.
		//A chaque fois qu'un getter est appelé sur l'agenda et que le jour n'existe pas, on l'ajoute.
	}
	
	private void addMonthToAgenda(LocalDate date)
	{
		int lengthOfMonth = date.lengthOfMonth();
		LocalDate today = date;
		for (int i = 1 ; i < lengthOfMonth ; i++)
		{
			today = today.withDayOfMonth(i);
			agenda.put(today, new Day());
		}
	}
	
	// === GETTERS ====
	
	public DayEvent getCurrentDayEvent()
	{
		return agenda.get(currentDate).getDayEvent();
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
	
	public DayEvent getDayEvent(LocalDate date)
	{
		return agenda.get(date).getDayEvent();
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
	
//	public void addEventToCalendar()
//	{
//		//Test ajout d'un match:
//		EventMatch matchEnCours = new EventMatch(teamDatabase.get(1), teamDatabase.get(4));
//		agenda.get(LocalDate.now().plusDays(1)).setDayEvent(matchEnCours);
//	}
	
	// === DISPLAY ===
	
	private void printCalendar() 
	{
		Set<LocalDate> keys = agenda.keySet();
		Iterator<LocalDate> itr = keys.iterator();

		while (itr.hasNext()) 
		{
			LocalDate localDate = itr.next();
			Day day = agenda.get(localDate);
			System.out.println(localDate + ": " + day.getDayEvent().getEventDescription());
		}
	}
	
	public LocalDate getCurrentDate() {
		return currentDate;
	}
}
