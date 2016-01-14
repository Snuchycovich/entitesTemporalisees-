package entites_temporalisees.state;

import entites_temporalisees.EntityTime;
import entites_temporalisees.Time;

public class SyncronyzedState extends TimeState{

	public SyncronyzedState(Time time) {
		super(time);
		this.startTime = 0;
	}
	
	public void adjustBorneAtAdd(EntityTime et) {
		long duree = time.duree(et.getFinishTime(), et.getStartTime());
		if (  duree > finishTime) {
			finishTime = duree;
		}
	}

	@Override
	protected void setTime(EntityTime et) {
		et.setCurrentTime(et.getStartTime() + currentTime);
	}

	@Override
	public void adjustBorneAtRemove(EntityTime et) {
		if (et.getFinishTime() == finishTime) {
			long tempSup = this.time.getListEntities().get(0).getFinishTime();
			for (EntityTime entite : this.time.getListEntities()) {
				
				if (time.duree(et.getFinishTime(), et.getStartTime()) > tempSup) {
					tempSup = entite.getFinishTime();
				}
			}
			finishTime = tempSup;
		}
		
	}
	

}
