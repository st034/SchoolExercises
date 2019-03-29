/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2018/12/12
 */
import java.util.Scanner;

public class SStack{
	protected int ind;
	protected int max;
	protected char[] st;
	
    public SStack(int m) {
    	max=m;
    	ind=0;
    	st=new char[max];
    }
    public void push(char el) throws IndexOutOfBoundsException{
    	if(ind==max){
    		throw new IndexOutOfBoundsException("Stack pieno");
    	}else{
    		st[ind]=el;
    		ind++;
    	}
    }
    public char pop() throws IndexOutOfBoundsException{
    	if(ind==0){
    		throw new IndexOutOfBoundsException("Stack vuoto");
    	}else{
    		ind--;
    		return st[ind];
    	}
    }
    public char top(){
    	return st[ind-1];
    }
    public boolean isEmpty(){
    	return ind==0;
    }
    public static void main(String[] args){
    	Scanner s=new Scanner(System.in);
    	System.out.println("inserisci una parola");
    	String word=s.nextLine();
    	SStack wordChar = new SStack(word.length());
    	for(int i=0;i<word.length();i++){
    		wordChar.push(word.charAt(i));
    	}
    	for(int i=0;i<word.length();i++){
    		System.out.print(wordChar.pop());
    	}
    	
    }
}