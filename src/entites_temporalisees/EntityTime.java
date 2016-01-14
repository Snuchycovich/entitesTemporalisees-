package entites_temporalisees;

import generic.ListenableModel;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityTime extends ListenableModel {
  
	private long startTime;
	private long finishTime;
	private long currentTime;
	private List<StateEntity> listState;
	
	public EntityTime(long startTime, long finishTime, long currentTime, List<StateEntity> lst){
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.currentTime = currentTime;
		this.listState = lst;
	}
	
	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	public List<StateEntity> getListState() {
		return listState;
	}

	public void setListState(ArrayList<StateEntity> listState) {
		this.listState = listState;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setFinishTime(long finishTime) {
		this.finishTime = finishTime;
	}

	public long getStartTime(){
		return this.startTime;
	}
	
	public long getFinishTime(){
		return this.finishTime;
	}
	
	public long gerCurrentTime(){
		return this.currentTime;
	}
	
}
