
import java.util.*;
import java.time.*;

public class Main {
	public static void main(String[] args){
		//MyFrame frame=new MyFrame();
		
		//libreria necessaria per la classe Calendar: java.time.*;
		Calendar c=new GregorianCalendar();
		int ore=c.get(Calendar.HOUR),minuti=c.get(Calendar.MINUTE),secondi=c.get(Calendar.SECOND);

		
		//inizializzazione orologio
		TimeSeconds t=new TimeSeconds(ore,minuti,secondi);
		Sveglia s=new Sveglia(ore,minuti,secondi);

		String clr="\n\n\n\n\n\n\n";
		s.setSveglia(9,56,1);
		do{
			System.out.println(clr);
			//frame.print(t.toString());	
			t.incSeconds();
			s.incMinuti();
			s.suona();
			System.out.println(t.toString());			
			Thread.sleep(1000);
		}while(1!=2);
  	}
}
