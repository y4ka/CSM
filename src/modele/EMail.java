package modele;

public class EMail 
{
	public enum EMAIL_TYPE {INFORMATION, INVITATION};
	
	private EMAIL_TYPE emailType;
	private boolean answered = false;
	
	public void Email(EMAIL_TYPE emailType)
	{
		this.emailType = emailType;
	}
}
