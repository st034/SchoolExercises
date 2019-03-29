/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2019/1/29
 */


public class Main{
    public static void main(String[] args){
    	//Queue<String> c=new Queue<String>();   con questa line da' errore perché la classe String non estende Number, come indicato nella classe Nodo e Queue
    	Queue<Integer> c=new Queue<Integer>();//Integer estende Number quindi no problem
    	c.enqueue(20);
    	c.enqueue(40);
    	c.enqueue(60);
    	System.out.println(c.dequeue());
    	System.out.println(c.dequeue());
    	System.out.println(c.dequeue());
    }    
}