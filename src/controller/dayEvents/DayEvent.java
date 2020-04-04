package controller.dayEvents;

public interface DayEvent {

	public enum DAY_EVENTS {REPOS, ENTRAINEMENT_COLLECTIF, ENRAINEMENT_INDIVIDUEL, MATCH, COHESION, SPORT, DEPLACEMENT};
	
	public void startEvent();
	public void endEvent();
	public DAY_EVENTS getEventType();
	public String getEventDescription();
}
