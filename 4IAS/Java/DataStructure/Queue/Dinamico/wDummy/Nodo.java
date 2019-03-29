/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Nodo<T> {
	private T info;
	private Nodo next;
    public Nodo(T info, Nodo next) {
    	this.info=info;
    	this.next=next;
    }
    public void setInfo(T info){
    	this.info=info;
    }
    public void setNext(Nodo next){
    	this.next=next;
    }
    public T getInfo(){
    	return info;
    }
    public Nodo getNext(){
    	return next;
    }
}