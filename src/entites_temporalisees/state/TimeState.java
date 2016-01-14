package entites_temporalisees.state;

import entites_temporalisees.EntityTime;
import entites_temporalisees.Time;

public abstract class TimeState {
	
	protected long startTime;
	protected long finishTime;
	protected long currentTime;
	protected Time time; 
	public TimeState(Time time){
		this.time = time;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getFinishTime() {
		return finishTime;
	}

	public long getCurrentTime() {
		return currentTime;
	}
	
	public void setCurrentTime(long l){
		this.currentTime = l;
	}
	
	public void setCurrentTimeFromRatio(double r){
		this.currentTime = (long) (startTime + r*(finishTime-startTime));
		
		for (EntityTime et: time.getListEntities()){
			setTime(et);
		}
	}
	
	public abstract void adjustBorneAtAdd(EntityTime et);
	public abstract void adjustBorneAtRemove(EntityTime et);
	protected abstract void setTime(EntityTime et); 
}
