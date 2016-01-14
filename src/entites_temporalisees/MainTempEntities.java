package entites_temporalisees;

import java.util.ArrayList;
import java.util.List;

import components.TimeControler;

public class MainTempEntities {

	public static void main(String[] args) {
		List <StateEntity> lst = new ArrayList<>();
		lst.add(new StateEntity("dormir", 10, 30));
		lst.add(new StateEntity("aboyer", 35, 40));
		lst.add(new StateEntity("manger", 50, 80));
		
		Time time = new Time(0);
	
		time.addEntityTime(new Chien((long)0,(long)80,(long)10,lst));
		new TimeControler(time);

	}

}
