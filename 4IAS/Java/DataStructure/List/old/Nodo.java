/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/2/20
 */


public class Nodo<T> {
    T info;
    Nodo<T> next;
    public Nodo(T info, Nodo next){
    	this.info=info;
    	this.next=next;
    }
}