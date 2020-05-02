package controller.dayEvents;

public abstract class DayEvent {

	public enum DAY_EVENTS {REPOS, ENTRAINEMENT_COLLECTIF, ENRAINEMENT_INDIVIDUEL, MATCH, COHESION, SPORT, DEPLACEMENT};
	
	protected DAY_EVENTS eventType;
	protected String eventDescription;
	protected boolean started;
	protected boolean finished;
	protected boolean brifed;
	protected boolean debrifed;
	
	public abstract void startEvent();
	public abstract void endEvent();
	
	public DAY_EVENTS getEventType()
	{
		return eventType;
	}
	
	public String getEventDescription() 
	{
		return eventDescription;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isBrifed() {
		return brifed;
	}

	public void setBrifed(boolean brifed) {
		this.brifed = brifed;
	}

	public boolean isDebrifed() {
		return debrifed;
	}

	public void setDebrifed(boolean debrifed) {
		this.debrifed = debrifed;
	}
}
