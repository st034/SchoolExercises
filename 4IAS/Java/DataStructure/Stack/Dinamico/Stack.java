/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class Stack<T>{
	Nodo<T> head;
	Nodo<T> dummy;
	public Stack(){
		head=null;
		dummy=head;
	}
	public void push(T value){
		head = new Nodo(value, head);
		dummy=head;
	}
	public T pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack vuoto");
		}else{
			T tmp=head.info;
			head=head.next;
			dummy=head;
			return tmp;
		}
	}
	public boolean isEmpty(){
		return head==null;
	}
	public int length(){
		if(dummy==null){
			return 0;
		}else{
			dummy=dummy.next;
			return length()+1;
		}
	}
	public boolean equals(Stack<T> el){
		if((head==null&&el.head!=null)||(head!=null&&el.head==null)){
			return false;
		}else{
			return equals(head,el.head);
		}
	}
	private boolean equals(Nodo<T> tmp1, Nodo<T> tmp2){
		if(tmp2==null){
			return tmp1==null;
		}else{
			if(tmp2.equals(tmp1)){
				return equals(tmp1.next, tmp2.next);
			}else{
				return false;
			}
		}
	}
}