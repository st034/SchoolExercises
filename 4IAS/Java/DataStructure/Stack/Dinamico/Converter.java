/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/2/18
 */

/*!!!!!!!!!!!!!     UTILIZZARE METODO: 100101  ==  (((((1*2+0)+2+0)*2+1)*2+0)*2+1)    !!!!!!!!!!!!!!*/
public class Converter {
    public String decToBin(Integer dec) {
		if(dec==0){
			return ""+0;
		}else{
	    	Stack<Integer> stack=new Stack<Integer>();
	    	String result="";
	    	do{
	    		stack.push(dec%2);
	    		dec=dec/2;
	    		
	    	}while(dec>0);
	    	boolean cond=true;
			do{
				try{
					System.out.print(stack.pop());
				}catch(Exception e){cond=false;}
			}while(cond);
	    	return result;
		}
    }
    public int binToDec(String bin){
    	Stack<Character> stack=new Stack<Character>();
    	int result=0;
		if(bin.equals(0)){
			return 0;
		}else{
	    	for(int i=0; i<bin.length(); i++){
	    		stack.push(bin.charAt(i));
	    	}
	    	for(int i=0; i<bin.length();i++){
	    		try{
		    		if(stack.pop()=='1'){
		    			result+=(int)Math.pow(2,i);
		    		}
	    		}catch(Exception e){}
	    	}
	    	return result;
		}
    }
    public String decToOct(int dec){
    	Stack<Integer> stack=new Stack<Integer>();
    	String result="";
    	if(dec==0){
    		return "0";
    	}else{
	    	do{
	    		stack.push(dec%8);
	    		dec=dec/8;
	    	}while(dec>0);
	    	boolean cond=true;
	    	do{
	    		try{
	    			result=result+stack.pop();
	    		}catch(Exception e){cond=false;}
	    	}while(cond);
	    	return result;
    	}
    }
    public int octToDec(String oct){
		if(oct.equals("0")){
			return 0;
		}else{
	    	Stack<Character> stack=new Stack<Character>();
	    	int result=0;
	    	for(int i=0; i<oct.length(); i++){
	    		stack.push(oct.charAt(i));
	    	}
	    	for(int i=0; i<oct.length();i++){
	    		try{
		    		result+=(int)Math.pow(8,i)*Character.getNumericValue(stack.pop());
	    		}catch(Exception e){}
	    	}
	    	return result;
		}
    }
}
class Main{
	public static void main(String[] args){
		String bin="1001011";
		int result=0;
		boolean cond=true;
		binToDec(bin,0,0);
	}
	public int binToDec(String bin, int i, int result){
		if(i==bin.length()){
			return result;
		}else{
			result=result*binToDec(bin, i++, result);
			return result*2+Character.getNumericValue(bin.charAt(i));
		}
	}
}