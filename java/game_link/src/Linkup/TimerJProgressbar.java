package Linkup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import Dialog.RecordJDialog;
import tools.Param;

public class TimerJProgressbar extends JProgressBar implements ActionListener {
	int count= Param.timeCount;
	Timer timer = new Timer(1000,this);
	LinkeUpMainFrame mainFrame;
	public  TimerJProgressbar(LinkeUpMainFrame mianFrame){
		this.mainFrame=mainFrame;
		this.setMaximum(count);
		this.setValue(count);
		this.setString(count+"秒");
		this.setStringPainted(true);
		this.setForeground(Color.gray);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count--;
		if(count>0){
				
			this.setValue(count);
			this.setString(count+"秒");
		}else if(count<=0){
				//Param.gameStatus=3;
				
				
				new RecordJDialog(mainFrame);
			    timer.stop();
				repaint();
				Param.gameStatus=3;
				
				return;
				
			}
		
			
	}
  
	public  void  start(){
		timer.start();
	}
	
	public void  stop(){
		timer.stop();
	}
	public void reset(){
		timer.stop();
		count=Param.timeCount;
		this.setMaximum(count);
		this.setValue(count);
		this.setString(count+"秒");
	}
	

}