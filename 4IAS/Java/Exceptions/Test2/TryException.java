/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2018/11/28
 */


public class TryException {

    public TryException() {
    }
    public void ciao() throws Exception{
    	throw new Exception();
    }
    public static void main(String[] args){
    	TryException n=new TryException();
    	try{
    		n.ciao();
    	}catch(Exception e){
    		System.out.println(e);
    	}
    }
    
}