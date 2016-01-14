package entites_temporalisees;

import java.util.ArrayList;
import java.util.List;

public class Chien extends EntityTime{

	

	public Chien(long startTime, long finishTime, long currentTime,
			List<StateEntity> lst) {
		super(startTime, finishTime, currentTime, lst);
	}

}
