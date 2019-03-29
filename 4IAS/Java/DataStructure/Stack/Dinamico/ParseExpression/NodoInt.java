/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class NodoInt {
	int info;
	NodoInt next;
	
    public NodoInt(int info) {
    	this.info=info;
    }
    public NodoInt(int info,NodoInt next){
    	this.next=next;
    	this.info=info;
    }
}
