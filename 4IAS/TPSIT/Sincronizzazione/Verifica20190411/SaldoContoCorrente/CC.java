/**
 * @(#)CC.java
 *
 *
 * @author 
 * @version 1.00 2019/4/11
 */


public class CC {
	int saldo;
    public CC(int saldo) {
    	this.saldo=saldo;
    }
    public synchronized void incrementa(){
    	saldo++;
    	System.out.println(saldo);
    }
    public synchronized void decrementa(){
    	saldo--;
    	System.out.println(saldo);
    }
}