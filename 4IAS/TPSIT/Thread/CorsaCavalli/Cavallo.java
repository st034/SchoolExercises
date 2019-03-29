/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2018/12/23
 */


public class Cavallo extends Thread{
	
	String nickname;
	int numero,index, ultimaPosizione;
	int[] forma;
	long timeStart, time;
	boolean caduto;
	
    public Cavallo(String nick, int n) {
    	nickname=nick;
    	numero=n;
    	forma=new int[3];
    	index=0;
    }
    public Cavallo(String nick, int n, int[] form, int ind, long tim, boolean cad) {
    	nickname=nick;
    	numero=n;
    	forma=form;
    	index=ind;
    	time=tim;
    	caduto=cad;
    }
    public void run(){
    	partenza();
    	if(corsa()){
    		arrivo();
    		if(time>900){
    			caduto=true;
    			time=Long.MAX_VALUE;
    		}else{
    			caduto=false;
    		}
    	}else{
    		time=Long.MAX_VALUE;
    		caduto=true;
    	}
    	if(caduto){
    		System.out.println("Il cavallo n° "+numero+" "+nickname+" è caduto!");
    	}else{
    		System.out.println("Il cavallo n° "+numero+" "+nickname+" è arrivato in "+time+"ms!");
    	}
    }
    private void partenza(){
    	timeStart=System.currentTimeMillis();
    }
    private boolean corsa(){
    	int random;
    	if(caduto){
    		random=(int)(Math.random()*1200);
    	}else{
    		random=(int)(Math.random()*1000);
    	}
    	try{
    		Thread.sleep(random);
    	}catch(InterruptedException e){
    		return false;
    	}
    	return true;
    }
    private void arrivo(){
    	time=System.currentTimeMillis()-timeStart;
    }
    public long getTime(){
    	return time;
    }
    public int getNumber(){
    	return numero;
    }
    public String toString(){
    	return "Nickname: "+nickname+" | Numero "+numero+" | Forma "+java.util.Arrays.toString(forma)+"\n";
    }
    public Cavallo copy(){
    	return new Cavallo(this.nickname, this.numero, this.forma, this.index, this.time, this.caduto);
    }
    public void aggiornaForma(){
    	if(index<3){
    		forma[index]=ultimaPosizione;
    		index++;
    	}else{
    		for(int k=0;k<forma.length;k++){
    			if(k<forma.length-1){
    				forma[k]=forma[k+1];
    			}else{
    				forma[k]=ultimaPosizione;
    			}
    		}
    	}
    }
    public boolean equals(Cavallo c){
    	return c.numero==this.numero;
    }
    public void setUltimaPosizione(int i){
    	ultimaPosizione=i;
    }
}