
public class TestException {

    public static void main(String[] args){
    	try{
    		MyClass m = new MyClass();
    		m.tentaException();
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    }
}