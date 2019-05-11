import java.util.Iterator;
public class AlberoIterator implements Iterator{
	Node cursor;
	public AlberoIterator(AlberoIterable a){
		cursor = a.root;
	}
	public boolean hasNext(){
		return cursor != null;
	}
	public Object next(){
		Object tmp = cursor.info;
		cursor = cursor.sx;
		return tmp;
	}
}