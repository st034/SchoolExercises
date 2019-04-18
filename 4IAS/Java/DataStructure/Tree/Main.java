import java.util.*;
public class Main{
	public static void main(String[] args){
		Albero a=new Albero();
		for(int i=0; i<20; i++){
			a.insertElement((int)(Math.random()*100));
		}
		a.preOrder();
		System.out.println("depth: "+a.noOfElements());
	
		
	}
}