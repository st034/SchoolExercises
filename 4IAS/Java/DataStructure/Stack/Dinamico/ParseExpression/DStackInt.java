/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class DStackInt{
	NodoInt head;
	public DStackInt(){
		head=null;
	}
	public void push(int value){
		head = new NodoInt(value, head);
	}
	public int pop() throws Exception{
		if(!isEmpty()){
			int tmp=head.info;
			head=head.next;
			return tmp;
		}else{
			throw new Exception("Stack vuoto");
		}
	}
	public boolean isEmpty(){
		return head==null;
	}
}