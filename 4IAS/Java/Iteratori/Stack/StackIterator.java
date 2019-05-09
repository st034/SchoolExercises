/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/9
 */
import java.util.Iterator;

public class StackIterator implements Iterator{
	Nodo cursor;
	
	public StackIterator(StackIterable s){
		cursor=s.head;
	}
	public boolean hasNext(){
		return cursor!=null;
	}
	public Object next(){
		Object tmp = cursor.info;
		cursor=cursor.next;
		return tmp;
	}
}