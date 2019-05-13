public class AlberoIterable extends Albero implements Iterable{
	public AlberoIterator iterator(){
		return new AlberoIterator(this);
	}
}