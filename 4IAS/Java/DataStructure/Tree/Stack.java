public class Stack<T>{
	Nodo<T> head;
	public Stack(){
		head=null;
	}
	public void push(T el){
		head=new Nodo(el, head);
	}
	public T pop(){
		if(!isEmpty()){
			T tmp=head.info;
			head=head.next;
			return tmp;
		}else{
			throw new NullPointerException("Stack empty");
		}
	}
	public boolean isEmpty(){
		return head==null;
	}
}
class Nodo<T>{
	Nodo<T> next;
	T info;
	public Nodo(T el, Nodo nex){
		next=nex;
		info=el;
	}
}