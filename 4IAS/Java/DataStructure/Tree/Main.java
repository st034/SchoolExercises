import java.util.*;
public class Main{
	public static void main(String[] args){
		Albero a=new Albero();
		Scanner scn=new Scanner(System.in);
		for(int i=0; i<10; i++){
			a.insertElement(scn.nextInt());
		}
		//a.preOrder();
		System.out.println();
		a.inOrder();
		System.out.println();
		//a.postOrder();
		System.out.println("controllo:");
		System.out.println(a.exists(scn.nextInt()));
	}
}