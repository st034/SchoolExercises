/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Main{
    public static void main(String[] args){
    	QueueIterable q=new QueueIterable();
    	
    	for(int i=0; i<20; i++){
    		q.enqueue(i);
    	}
    	for(Object x: q){
    		System.out.println(x);
    	}
    }    
}