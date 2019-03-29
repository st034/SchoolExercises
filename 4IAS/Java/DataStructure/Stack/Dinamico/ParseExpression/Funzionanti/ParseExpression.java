/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/16
 */
import java.util.*;

public class ParseExpression {
	DStackString operand;
	DStackString operat;
    public ParseExpression() {
    	operand=new DStackString();
    	operat=new DStackString();
    }
    public int getResult(String s) throws Exception{
    	String c,op;
    	int a,b;
    	String tmp;
    	for(int i=0;i<s.length();i++){
    		c=Character.toString(s.charAt(i));
    		if(isInteger(c)){
    			operand.push(c);
    		}
    		if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
    			getOperat(c);
    		}
    		if(c.equals(")")||c.equals("]")||c.equals("}")){
				try{
	    			a=Integer.parseInt(operand.pop());
	    			b=Integer.parseInt(operand.pop());
	    			op=operat.pop();
    				//System.out.println(b+" "+op+" "+a);
	    			if(op.equals("+")){
	    				operand.push(Integer.toString(b+a));
	    			}
	    			if(op.equals("-")){
	    				operand.push(Integer.toString(b-a));
	    			}
	    			if(op.equals("*")){
	    				operand.push(Integer.toString(b*a));
	    			}
	    			if(op.equals("/")){
	    				operand.push(Integer.toString(b/a));
	    			}
    			}catch(Exception e){System.out.println("Qualcosa non va");}
    		}
    	}
    	int result=Integer.parseInt(operand.pop());
    	if(!operand.isEmpty()){
    		throw new Exception("Sintassi scorretta");
    	}else{
    		return result;
    	}
    }
    private void getOperat(String c){
    	if(c.equals("+")){
    		operat.push("+");
    	}
    	if(c.equals("-")){
    		operat.push("-");
    	}
    	if(c.equals("*")){
    		operat.push("*");
    	}
    	if(c.equals("/")){
    		operat.push("/");
    	}
    }
    private boolean isInteger(String c){
    	if(c.equals("0")||c.equals("1")||c.equals("2")||c.equals("3")||c.equals("4")||c.equals("5")||c.equals("6")||c.equals("7")||c.equals("8")||c.equals("9")){
    		return true;
    	}else{
    		return false;
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