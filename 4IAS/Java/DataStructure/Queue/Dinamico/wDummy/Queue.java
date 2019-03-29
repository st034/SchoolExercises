/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Queue<T> {
	private Nodo<T> head;
	private Nodo<T> tail;
    
    public Queue() {
    	Nodo<T> dummy=new Nodo<T>(null,null);
    	head=dummy;
    	tail=dummy;
    }
    public boolean isEmpty(){
    	return head==tail;
    }
    public void enqueue(T info){
    	Nodo<T> tmp=new Nodo<T>(null,null);
    	tail.setInfo(info);
    	tail.setNext(tmp);
    	tail=tmp;
    }
    public T dequeue() throws NullPointerException{
    	if(!isEmpty()){
    		T tmp=head.getInfo();
    		head=head.getNext();
    		return tmp;
    	}else{
    		throw new NullPointerException("Queue Vuota");
    	}		
    }
}