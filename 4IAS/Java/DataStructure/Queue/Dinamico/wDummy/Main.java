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
    	c.enqueue(20);
    	c.enqueue(40);
    	c.enqueue(60);
    	System.out.println(c.dequeue());
    	System.out.println(c.dequeue());
    	System.out.println(c.dequeue());
    }    
}