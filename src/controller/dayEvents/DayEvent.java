package controller.dayEvents;

import java.awt.Color;

public abstract class DayEvent {

	public enum DAY_EVENTS {REPOS, ENTRAINEMENT_COLLECTIF, ENRAINEMENT_INDIVIDUEL, MATCH, COHESION, SPORT, DEPLACEMENT};
	public enum EVENT_STATUS {NOT_STARTED, BRIEFED, STARTED, DEBRIEFED, ENDED};
	
	protected DAY_EVENTS eventType;
	protected EVENT_STATUS eventStatus;
	
	protected String eventDescription;
	protected Color eventColor;
	
	public abstract void startEvent();
	public abstract void endEvent();
	
	public DayEvent()
	{
		eventStatus = EVENT_STATUS.NOT_STARTED;
	}
	
	public DAY_EVENTS getEventType()
	{
		return eventType;
	}
	
	public EVENT_STATUS getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(EVENT_STATUS eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getEventDescription() 
	{
		return eventDescription;
	}
	
	public Color getEventColor() {
		return eventColor;
	}
}
