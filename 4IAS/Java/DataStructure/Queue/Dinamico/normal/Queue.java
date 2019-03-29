/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Queue<T>{
	Nodo<T> head;
	Nodo<T> tail;
    public Queue() {
    	head=null;
    	tail=null;
    }
    public boolean isEmpty(){
    	return head==null&&tail==null;
    }
    public long length(){
    	Nodo<T> dummy=head;
    	return recLength(dummy, 0);
    }
    private long recLength(Nodo<T> dummy, int i){
    	if(dummy==null){
    		return 0;
    	}else{
    		return recLength(dummy.getNext(),i+1);
    	}
    }
    public long normLength(){
    	Nodo<T> dummy=head;
    	long i=0;
    	if(dummy==null){
    		return 0;
    	}else{
    		do{
    			dummy=dummy.getNext();
    			i++;
    		}while(dummy!=null);
    		dummy=head;
    		return i;
    	}
    }
    /*
    public String toString(){
    	String s="";
    	if(dummy==null){
    		dummy=head;
    		return s;
    	}else{
    		s+=dummy.getInfo()+"; ";
    		dummy=dummy.getNext();
    		s+=toString();
    		return s;
    	}
    }*/
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
}