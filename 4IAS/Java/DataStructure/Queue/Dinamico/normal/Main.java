/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Main{
    public static void main(String[] args){
    	Queue<Integer> c=new Queue<Integer>();
    	for(int i=0; i<20000;i++){
    		c.enqueue(i);
    	}
    	//System.out.println(c.normLength());
    	//long time=System.currentTimeMillis();
    	//System.out.println(c.recLength());
    	//time=System.currentTimeMillis()-time;
    	//System.out.println("Recursive: "+time+"ms");
    	
    	//time=System.currentTimeMillis();
    	//System.out.println(c.normLength());
    	//time=System.currentTimeMillis()-time;
    	//System.out.println("Non Recursive: "+time+"ms");
    	System.out.println(c.length());
    }    
}