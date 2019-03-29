import java.util.*;
public class Ippodromo {

    public Ippodromo(){
	    Gara g=new Gara();
	    Scanner scn=new Scanner(System.in);
	    boolean esc=true;
	    String clear="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	    do{
	    	g.start();
	    	System.out.println("Premi 1 per uscire, 0 per restare e tentare una nuova partita");
	    	int tmp=scn.nextInt();
	    	if(tmp==1){esc=false;}
	    	else{g.restart();}
	    	System.out.println(clear);
	    }while(esc);
    }
    
    
}