/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */


public class DStackString{
	NodoString head;
	public DStackString(){
		head=null;
	}
	public void push(String value){
		head = new NodoString(value, head);
	}
	public String pop() throws Exception{
		if(!isEmpty()){
			String tmp=head.info;
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