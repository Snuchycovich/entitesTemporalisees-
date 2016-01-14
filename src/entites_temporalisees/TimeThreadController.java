package entites_temporalisees;

import java.util.Date;

public class TimeThreadController implements Runnable{
	
	private Time time;
	long lastT = -1;
	private volatile boolean threadSuspensed; 
	private Thread thread;
	public final static int THREAD_SLEEPING_TIME = 25;
	
	public TimeThreadController(Time time) {
		this.time = time;
	}
	
	public synchronized void start(){
		System.out.println("start");
		if(thread == null) {
			thread = new Thread(this);
			threadSuspensed = false;
			thread.start();
		}
		else {
			System.out.println("resume");
			if(threadSuspensed) {
				threadSuspensed = false;
				notify();
			}
		}
	}
	
	public void stop() {
		threadSuspensed = true;
		lastT = -1;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("avant: "+time.getCurrentTime());
			try {
				Thread.sleep(THREAD_SLEEPING_TIME);
				if(threadSuspensed) {
					synchronized (this) {
						while (threadSuspensed)
							wait();
					}
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			//ajouter temps de sleep au time
			//time.setCurrentTime(time.getCurrentTime() + THREAD_SLEEPING_TIME);
			
			
			Date d = new Date();
			long t = d.getTime();
			if(lastT<0){
				lastT = t;
			}
			long duree = t-lastT;
			time.setCurrentTime(time.getCurrentTime()+duree);
			lastT = t;
			System.out.println("après: "+time.getCurrentTime());
		}
			
	}
}

