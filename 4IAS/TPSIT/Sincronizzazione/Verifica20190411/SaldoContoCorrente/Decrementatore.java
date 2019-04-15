/**
 * @(#)Incrementatore.java
 *
 *
 * @author 
 * @version 1.00 2019/4/11
 */


public class Decrementatore extends Thread{
	CC contoCorrente;
    public Decrementatore(CC cc) {
    	contoCorrente=cc;
    	this.start();
    }
    public void run(){
    	for(int i=0; i<10; i++){
    		contoCorrente.decrementa();
    	}
    }
    
}