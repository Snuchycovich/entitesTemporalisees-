package components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entites_temporalisees.Time;
import entites_temporalisees.TimeThreadController;
import generic.SimpleChangeListener;


public class TimeControler extends JFrame implements ActionListener, ChangeListener, SimpleChangeListener{
	
	private Time time;
	private TimeThreadController timeThread;
	private JTextField textStartTime;
	private JTextField textCurrentTime;
	private JTextField textFinishTime;
	private JSlider slider;
	private JButton btnStart;
	private JButton btnFinish;
	private JButton btnPlay;
	private JButton btnPause;

	public TimeControler(Time time) {
		this.time = time;
		this.timeThread = new TimeThreadController(time);
		
		this.setLayout(new GridLayout(4, 1 ));
		slider = new JSlider(JSlider.HORIZONTAL,
                0, (int)time.getFinishTime(), (int)time.getStartTime());
		
		//component
		JPanel labelPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel sliderPanel = new JPanel();
		JPanel statePanel = new JPanel(); 
		
		slider.addChangeListener(this);
		
		btnStart = new JButton("Début");
		btnFinish = new JButton("Fin");
		btnPlay = new JButton("Play");
		btnPause = new JButton("Pause");
		
		btnStart.addActionListener(this);
		btnFinish.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		
		this.add(labelPanel);
		this.add(buttonsPanel);
		this.add(sliderPanel);
		this.add(statePanel);
		labelPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.setLayout(new GridLayout(1,4));
		
		buttonsPanel.add(btnStart);
		buttonsPanel.add(btnPlay);
		buttonsPanel.add(btnPause);
		buttonsPanel.add(btnFinish);
		this.setSize(300, 200);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(((JButton) e.getSource() == this.btnStart)){
			time.setCurrentTime(time.getStartTime());
		} else if(((JButton) e.getSource() == this.btnFinish)){
			time.setCurrentTime(time.getFinishTime());
		} else if (((JButton) e.getSource() == this.btnPlay)){
			timeThread.start();
		} else if (((JButton) e.getSource() == this.btnPause)) {
			timeThread.stop();
		}
		
	}

	@Override
	public void stateChanged(Object source) {
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
