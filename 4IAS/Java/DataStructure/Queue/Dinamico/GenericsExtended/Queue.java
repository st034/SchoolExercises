/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Queue<T extends Number>{
	Nodo<T> head;
	Nodo<T> tail;
    public Queue() {
    	head=null;
    	tail=null;
    }
    public boolean isEmpty(){
    	return head==null&&tail==null;
    }
    public void enqueue(T info){
    	if(isEmpty()){
    		Nodo<T> tmp=new Nodo<T>(info,null);
    		head=tmp;
    		tail=tmp;
    	}else{
    		tail.setNext(new Nodo<T>(info,null));
    		tail=tail.getNext();
    	}
    }
    public T dequeue() throws NullPointerException{
    	if(!isEmpty()){
    		T tmp=head.getInfo();
    		head=head.getNext();
    		return tmp;
    	}else{
    		throw new NullPointerException("Queue Empty");
    	}
    }
    public static void main(String[] args){
    	Queue<Integer> c=new Queue<Integer>();
    	c.enqueue(20);
    	c.enqueue(40);
    	System.out.println(c.dequeue());
    	System.out.println(c.dequeue());
    }
    
}