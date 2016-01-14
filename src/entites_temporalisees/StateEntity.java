package entites_temporalisees;

public class StateEntity {

	private long startStateTime;
	private long finishStateTime;
	private String state;
		
	public StateEntity(String state, long startStateTime, long finiStateTime)
	{
		this.state = state;
		this.finishStateTime = finiStateTime;
		this.startStateTime = startStateTime;
	}

	public long getStartStateTime() {
		return startStateTime;
	}

	public void setStartStateTime(long startStateTime) {
		this.startStateTime = startStateTime;
	}

	public long getFinishStateTime() {
		return finishStateTime;
	}

	public void setFinishStateTime(long finishStateTime) {
		this.finishStateTime = finishStateTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
