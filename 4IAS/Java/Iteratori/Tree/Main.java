import java.util.*;
public class Main{
	public static void main(String[] args){
		AlberoIterable a = new AlberoIterable();
		int[] arr={12,6,3,7,20,15,21};
		
		for(int i=0; i<7; i++){
			a.insertElement(arr[i]);
		}
		for(Object x: a){
			System.out.println(x);
		}
	}
}