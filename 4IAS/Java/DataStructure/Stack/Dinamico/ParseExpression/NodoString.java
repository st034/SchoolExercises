/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class NodoString {
	String info;
	NodoString next;
	
    public NodoString(String info) {
    	this.info=info;
    }
    public NodoString(String info,NodoString next){
    	this.next=next;
    	this.info=info;
    }
}
