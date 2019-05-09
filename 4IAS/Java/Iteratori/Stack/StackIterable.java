public class StackIterable extends Stack implements Iterable{
	StackIterator iterator;
	
	public StackIterator iterator(){
		return new StackIterator(this);
	}
}