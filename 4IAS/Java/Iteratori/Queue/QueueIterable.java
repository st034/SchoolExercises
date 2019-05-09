
public class QueueIterable extends Queue implements Iterable{
	QueueIterator iterator;
	public QueueIterator iterator(){
		return new QueueIterator(this);
	}
}