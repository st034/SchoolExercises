public class StackIterable extends Stack implements Iterable{
	
	public StackIterator iterator(){
		return new StackIterator(this);
	}
}