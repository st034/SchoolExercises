/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/3/8
 */


public class Main {

    public static void main(String[] args){
    	Stack<Integer> st1 = new Stack<>();
    	Stack<Integer> st2 = new Stack<>();
    	for(int i=0; i<10; i++){
    		st1.push(i);
    		st2.push(i);
    	}
    	System.out.println("Da vero: "+st1.equals(st2));
    	try{
    		st2.pop();
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
    	System.out.println("Da falso: "+st1.equals(st2));
    	try{
    		st1.pop();
    		st1.pop();
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
    	System.out.println("Da falso: "+st1.equals(st2));
    	try{
    		st2.pop();
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
    	System.out.println("Da vero: "+st1.equals(st2));
    	st1=new Stack<Integer>();
    	st2=new Stack<Integer>();
    	System.out.println(st1.equals(st2));
    }
}