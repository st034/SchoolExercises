
import java.util.*;
import java.time.*;

public class Main {
	public static void main(String[] args){
		//inzizializzazione thread
		MyThread orologio=new MyThread();
		orologio.start();
		int x=9;
  	}
}
class MyThread extends Thread {
	String clr="\n\n\n\n\n\n\n";
	//libreria necessaria per la classe Calendar: java.time.*;
	Calendar c=new GregorianCalendar();		
	//inizializzazione orologio
	TimeSeconds t=new TimeSeconds(c.get(Calendar.HOUR),c.get(Calendar.MINUTE), Calendar.SECOND);
	public void run() {
		try{
			do{
				System.out.println(clr);	
				t.incSeconds();
				System.out.println(t.toString());			
				Thread.sleep(1000);
			}while(1!=2);
		}catch(Exception e){}
	}
}
