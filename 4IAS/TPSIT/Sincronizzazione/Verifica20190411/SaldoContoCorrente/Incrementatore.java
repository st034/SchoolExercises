/**
 * @(#)Incrementatore.java
 *
 *
 * @author 
 * @version 1.00 2019/4/11
 */


public class Incrementatore extends Thread{
	CC contoCorrente;
    public Incrementatore(CC cc) {
    	contoCorrente=cc;
    	this.start();
    }
    public void run(){
    	for(int i=0; i<10; i++){
    		contoCorrente.incrementa();
    	}
    }    
}