package generic;

import java.util.ArrayList;

public abstract class ListenableModel {

	private ArrayList<SimpleChangeListener> listenerList = new ArrayList();
	private SimpleChangeListener intanceSCL; 
	
	public void addSimpleChangeListener(SimpleChangeListener l)
	{
		this.listenerList.add(l);
	}
	
	public void removeSimpleChangeListener(SimpleChangeListener l)
	{
		this.listenerList.remove(l);
	}
	
	protected void fireSimpleChange()
	{
		for(SimpleChangeListener l : listenerList) {
			l.stateChanged(this);
		}
	}
}
