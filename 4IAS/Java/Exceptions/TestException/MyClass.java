
public class MyClass{
	public void tentaException() throws Exception{
		if(Math.random()<0.5){
			throw new MyException("My Exception");
		}
		else{
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}
}
