import java.util.Iterator;

public class QueueIterator implements Iterator{
	Nodo cursor;
	public QueueIterator(QueueIterable q){
		cursor=q.head;
	}
	public boolean hasNext(){
		return cursor!=null;
	}
	public Object next(){
		Object tmp=cursor.info;
		cursor=cursor.next;
		return tmp;
	}
}