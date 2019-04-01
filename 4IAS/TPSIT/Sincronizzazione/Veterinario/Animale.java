/**
 * @(#)Animale.java
 *
 *
 * @author 
 * @version 1.00 2019/4/1
 */


public class Animale extends Thread{
	Studio veterinario;
    public Animale(Studio s) {
    	veterinario = s;
    }
    public void run(){
    	try{
    		Thread.sleep((int)(Math.random()*1000));
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
    }
    
    
}