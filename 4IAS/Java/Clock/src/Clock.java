/**
 * @(#)Clock.java
 *
 * Clock application
 *
 * @author 
 * @version 1.00 2018/11/28
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Clock {
    private int hour, minute;
    Calendar c=new GregorianCalendar();
    public Clock(){
    	hour=c.get(Calendar.HOUR);
    	minute=c.get(Calendar.MINUTE);
    }
    public void incMinute(){
    	minute++;
    	if(minute==60){
    		minute=0;
    		hour++;
    		if(hour==24){
    			hour=0;
    		}
    	}
    }
    public String toString(){
    	return hour+":"+minute;
    }
    public static void main(String[] args){
    	ClockFrame c=new ClockFrame();
    }
}
class ClockSecond extends Clock{
	private int second;
	public ClockSecond(){
		second=c.get(Calendar.SECOND);
	}
	public void incSecond(){
		second++;
		if(second==60){
			second=0;
			this.incMinute();
		}
	}
	public String toString(){
		return super.toString()+":"+second;
	}
}
class ThreadClock extends Thread{
	static ClockSecond clock=new ClockSecond();
	public ThreadClock(){
		this.start();
	}
	public void run(){
		do{
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			clock.incSecond();
			ClockFrame.setClockText(clock.toString());
		}while(true);
	}
}
class ClockFrame extends JFrame{
	static JTextArea orologio = new JTextArea();
	
	public ClockFrame(){
		super("Orologio");		
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ThreadClock count=new ThreadClock();
	}
	public static void setClockText(String s){
		orologio.setText(s);
	}
}