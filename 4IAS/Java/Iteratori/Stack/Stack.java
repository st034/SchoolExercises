/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class Stack<T>{
	Nodo<T> head;
	public Stack(){
		head=null;
	}
	public void push(T el){
		head = new Nodo(el, head);
	}
	public T pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack vuoto");
		}else{
			T tmp=head.info;
			head=head.next;
			return tmp;
		}
	}
	public boolean isEmpty(){
		return head==null;
	}
}