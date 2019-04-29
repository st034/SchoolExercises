import java.util.*;
public class Main{
	public static void main(String[] args){
		Albero a=new Albero();
		int[] arr={12,6,3,7,20,15,21};
		for(int i=0; i<7; i++){
			//a.insertElement((int)(Math.random()*100));
			a.insertElement(arr[i]);
		}
		//a.preOrder();
		a.bracketsPrint();
		System.out.println();
		a.indentPrint();
	
		
	}
}