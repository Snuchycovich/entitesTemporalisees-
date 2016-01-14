package entites_temporalisees.state;

import entites_temporalisees.EntityTime;
import entites_temporalisees.Time;

public class NormalState extends TimeState{

	public NormalState(Time time) {
		super(time);
	}
	
	public void adjustBorneAtAdd(EntityTime et) {
		if(et.getFinishTime() > this.finishTime) {
			this.finishTime = et.getFinishTime();
		}
		if (et.getStartTime() < this.startTime) {
			this.startTime = et.getStartTime();
		}
	}

	@Override
	protected void setTime(EntityTime et) {
		et.setCurrentTime(currentTime);
	}

	@Override
	public void adjustBorneAtRemove(EntityTime et) {
		if (et.getStartTime() == startTime || et.getFinishTime() == finishTime) {
			long tempInferieur = this.time.getListEntities().get(0).getStartTime();
			long tempSup = this.time.getListEntities().get(0).getFinishTime();
			for (EntityTime entite : this.time.getListEntities()) {
				if (entite.getStartTime() < tempInferieur) {
					tempInferieur = entite.getStartTime();
				}
				if (entite.getFinishTime() > tempSup) {
					tempSup = entite.getFinishTime();
				}
			}
			startTime = tempInferieur;
			finishTime = tempSup;
		}
			
	}
	
}
