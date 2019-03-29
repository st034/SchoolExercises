/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class Nodo<T> {
	T info;
	Nodo next;
	
    public Nodo(T info) {
    	this.info=info;
    }
    public Nodo(T info,Nodo next){
    	this.next=next;
    	this.info=info;
    }
    public boolean equals(Nodo<T> el){
    	return info==el.info;
    }
}
