/**
 * @(#)ParsingParentesi.java
 *
 *
 * @author 
 * @version 1.00 2019/1/7
 */

import java.util.*;
public class ParsingParentesi {
	private String line;
	
    public ParsingParentesi(String line) {
    	this.line=line;
    }    
    public boolean checkBrackets(){
    	char byLine;
    	CharBy byStack=new CharBy();
    	SStack stack=new SStack(20);	    	
    	for(int i=0;i<line.length();i++){
			byLine=line.charAt(i);
			if(byLine=='('||byLine=='['||byLine=='{'||byLine==')'||byLine==']'||byLine=='}'){
				try{		
		    		if(byLine=='('||byLine=='['||byLine=='{'){
		    			stack.push(byLine);
			    	}else{			    		
			    		byStack.setChar(stack.pop());
				    	if(!byStack.match(byLine)){
				    		System.out.println("Parentesi non corrette");
				    		return false;
				    	}
			    	}			    	
		    	}catch(IndexOutOfBoundsException e){
		    		//troppo pieno o troppo vuoto
		    		System.out.println("Parentesi non corrette");
		    		return false;
		    	}
			}
    	}
    	if(!stack.isEmpty()){
    		System.out.println("Parentesi non corrette");
    		return false;
    	}
    	return true;
    }
    public static void main(String[] args){
    	Scanner scn=new Scanner(System.in);
		System.out.println("Inserisci la stringa:");
    	String line=scn.nextLine();
    	ParsingParentesi p=new ParsingParentesi(line);
    	if(p.checkBrackets()){
    		System.out.println("Parentesi ok");
    	}
    }
}
class CharBy{
	char c;

	public void setChar(char d){
		c=d;
	}
	public boolean match(char byLine){
    	return (c=='('&&byLine==')'||c=='['&&byLine==']'||c=='{'&&byLine=='}');
    }
}