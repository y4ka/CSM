package modele;

public class EMail 
{
	public enum EMAIL_TYPE {INFORMATION, ACTION};
	
	private EMAIL_TYPE emailType;
	private boolean answered = false;
	private boolean read = false;
	private String title;
	private String content;
	
	public EMail(EMAIL_TYPE emailType, String title, String content)
	{
		this.emailType = emailType;
		this.title = title;
		this.content = content;
	}

	public EMAIL_TYPE getEmailType() {
		return emailType;
	}

	public void setEmailType(EMAIL_TYPE emailType) {
		this.emailType = emailType;
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString()
	{
		return this.title;
	}
}
