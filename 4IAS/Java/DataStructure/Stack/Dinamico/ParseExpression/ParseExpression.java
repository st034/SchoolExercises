/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/16
 */
import java.util.*;

public class ParseExpression {
	DStackInt operand;
	DStackString operat;
	
    public ParseExpression() {
    	operand=new DStackInt();
    	operat=new DStackString();
    }
    public int getResult(String s) throws Exception{
    	Carattere c=new Carattere();
    	Carattere tmp=new Carattere();
    	String op;
    	int a,b;
    	for(int i=0;i<s.length();i++){
    		c.setCarattere(Character.toString(s.charAt(i)));
    		if(c.isInteger()){
    			tmp.setCarattere(""+s.charAt(i+1));
    			if(tmp.isInteger()){
    				i=i+tmp.getNumber(s,i);
    				operand.push(Integer.parseInt(tmp.getCarattere()));
    				
    			}else{
	    			operand.push(Integer.parseInt(c.getCarattere()));
    			}
    		}
    		if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
    			operat.push(c.getOperat());
    		}
    		if(c.equals(")")||c.equals("]")||c.equals("}")){
				try{
	    			a=operand.pop();
	    			b=operand.pop();
	    			op=operat.pop();
	    			operand.push(doOperation(a,b,op));
    			}catch(Exception e){System.out.println("Qualcosa non va");}
    		}
    	}
    	int result=operand.pop();
    	if(!operand.isEmpty()){
    		throw new Exception("Sintassi scorretta");
    	}else{
    		return result;
    	}
    }
    private int doOperation(int a, int b, String op){
    	if(op.equals("+")){
			return b+a;
		}
		if(op.equals("-")){
			return b-a;
		}
		if(op.equals("*")){
			return b*a;
		}
		else{
			return b/a;
		}    	
    }
    public static void main(String[] args){
    	ParseExpression p=new ParseExpression();
    	Scanner scn=new Scanner(System.in);
    	System.out.println("Inserisci l'espressione: ");
    	String expression=scn.nextLine();
    	try{
    		System.out.println(p.getResult(expression));
    	}catch(Exception e){System.out.println(e);}
    }
}
class Carattere{
	String c;
	public void setCarattere(String s){
		c=s;
	}
	public String getCarattere(){
		return c;
	}
	public boolean equals(String s){
		return c.equals(s);
	}
	public boolean isInteger(){
    	if(c.equals("0")||c.equals("1")||c.equals("2")||c.equals("3")||c.equals("4")||c.equals("5")||c.equals("6")||c.equals("7")||c.equals("8")||c.equals("9")){
    		return true;
    	}else{
    		return false;
    	}
    }
    public int getNumber(String s, int i){
    	String num="";
    	int j=0;
    	for(int k=i;k<s.length();k++){
    		setCarattere(""+s.charAt(k+1));
    		if(isInteger()){
    			num=num+getCarattere();
    			j++;
    		}
    	}
    	return Integer.parseInt(num);
    }
    public String getOperat(){
    	if(c.equals("+")){
    		return "+";
    	}
    	if(c.equals("-")){
    		return "-";
    	}
    	if(c.equals("*")){
    		return "*";
    	}
    	else{
    		return "/";
    	}
    }
}