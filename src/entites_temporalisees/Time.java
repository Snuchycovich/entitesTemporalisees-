package entites_temporalisees;

import entites_temporalisees.state.EnumStateTime;
import entites_temporalisees.state.NormalState;
import entites_temporalisees.state.SyncronyzedState;
import entites_temporalisees.state.TimeState;
import generic.ListenableModel;

import java.util.ArrayList;
import java.util.List;

public class Time extends ListenableModel{
	
	private List<EntityTime> listEntities;
	private TimeState currentState;
	private TimeState normalState;
	private TimeState syncronyzedState;
	
	public Time(long currentTime){
		listEntities = new ArrayList<>();
		normalState = new NormalState(this);
		syncronyzedState =  new SyncronyzedState(this);
		currentState = normalState;		
	}
	
	public void addEntityTime(EntityTime et) {
		listEntities.add(et);
		normalState.adjustBorneAtAdd(et);
		syncronyzedState.adjustBorneAtAdd(et);
	}
	public void removeEntityTime(EntityTime et) {
		listEntities.remove(et);
		normalState.adjustBorneAtRemove(et);
		syncronyzedState.adjustBorneAtRemove(et);
	}
	
	public void setState(EnumStateTime enumState) {
		currentState = (enumState == EnumStateTime.NORMAL) ? normalState : syncronyzedState;
	}
	
	public long getStartTime() {
		return currentState.getStartTime();
	}
	
	public long getCurrentTime() {
		return currentState.getCurrentTime();
	}
	
	public long getFinishTime() {
		return currentState.getFinishTime();
	}
	
	public void setCurrentTime(long l){
		currentState.setCurrentTime(l);
	}
	
	public void setCurrentTimeFromRatio(double r){
		currentState.setCurrentTimeFromRatio(r);
	}
	
	public long duree(long finishTime, long startTime) {
		return finishTime - startTime;
	}

	public List<EntityTime> getListEntities() {
		return listEntities;
	}
}
