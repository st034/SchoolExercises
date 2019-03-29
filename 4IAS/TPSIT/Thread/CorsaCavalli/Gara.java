
import java.util.*;

public class Gara{
	Cavallo[] gara=new Cavallo[10];
	Cavallo[] risultato=new Cavallo[10];
    Scommessa bet=new Scommessa(3);
    public Gara() {
    	gara[0]=new Cavallo("lulu",1);
    	gara[1]=new Cavallo("nick",2);
    	gara[2]=new Cavallo("graves",3);
    	gara[3]=new Cavallo("sinon",4);
    	gara[4]=new Cavallo("kirito",5);
    	gara[5]=new Cavallo("asuna",6);
    	gara[6]=new Cavallo("piccol",7);
    	gara[7]=new Cavallo("gohan",8);
    	gara[8]=new Cavallo("majin",9);
    	gara[9]=new Cavallo("supaidaman",10);
    }
    public void start(){
    	System.out.println("Scommetti su chi arriverà al podio tra i seguenti cavalli: ");
    	try{
    		Thread.sleep(500);
    	}catch(InterruptedException e){}
    	System.out.println(Arrays.toString(gara));
    	getBet();
    	for(Cavallo c: gara){
    		c.start();
    	}
    	for(Cavallo c: gara){
    		try{
    			c.join();
    		}catch(InterruptedException e){}
    	}
    	copyGara();
    	ordina();
    	aggiornaFormaCavalli();
    	if(bet.checkScommessa(risultato)){
    		System.out.println("Complimenti, HAI VINTO!");
    	}else{
    		System.out.println("Hai perso la scommessa :)");
    	}
    }
    private void getBet(){
    	Scanner scn=new Scanner(System.in);
    	for(int i=0; i<bet.getLength();i++){
    		System.out.println("Scegli il :"+(i+1));
    		bet.setBet(scn.nextInt(),i);
    	}
    }
    private void ordina(){
    	Cavallo tmp;
	    for(int k=0;k<risultato.length-1;k++){
	    	for(int i=0; i<risultato.length-1;i++){
	    		if(risultato[i].getTime()>risultato[i+1].getTime()){
	    			tmp=risultato[i+1];
	    			risultato[i+1]=risultato[i];
	    			risultato[i]=tmp;
	    		}
	    	}
	    }
    }
    private void copyGara(){
    	for(int i=0; i<gara.length;i++){
    		risultato[i]=gara[i].copy();
    	}
    }
    private void aggiornaFormaCavalli(){
    	for(int i=0;i<risultato.length;i++){
    		for(int k=0;k<risultato.length;k++){
    			if(gara[i].equals(risultato[k])){
    				gara[i].setUltimaPosizione(k+1);
    			}
    		}
    		gara[i].aggiornaForma();
    	}
    }
    public void restart(){
    	Cavallo[] tmp= new Cavallo[gara.length];
    	for(int i=0; i<gara.length;i++){
    		tmp[i]=gara[i].copy();
    	}
    	gara=tmp;
    }
}