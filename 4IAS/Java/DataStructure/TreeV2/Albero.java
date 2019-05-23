import java.util.Stack;
public class Albero{
	Node root;
	Stack stack;
	public Albero(String expression){		
		stack = new Stack();
		fillStack(expression);
		for(int i=0; i<expression.length(); i++){
			System.out.println(stack.pop());
		}
	}
	private void fillStack(String expr){
		for(int i=0; i<expr.length(); i++){
			if(isInteger(""+expr.charAt(i))){
				stack.push(expr.charAt(i));
			}else if(isOperand(expr.charAt(i))){
				stack.push(expr.charAt(i));
			}
		}
	}
	private boolean isOperand(char c){
		if(c == '+'||c == '-' || c == '*' || c == '/'){
			return true;
		}else{
			return false;
		}
	}
	public Integer eval(){
		return eval(root);
	}
	private Integer eval(Node root){
		if(root.sx==null){
			return Integer.parseInt(root.info);
		}else{
			int a=eval(root.sx);
			int b=eval(root.dx);
			return calculate(a, root.info, b);
		}
	}
	private Integer calculate(int a, String op, int b){
		if(op.equals("+")){
			return a+b;
		}
		else if(op.equals("-")){
			return a-b;
		}
		else if(op.equals("*")){
			return a*b;
		}
		else if(op.equals("/")){
			return a/b;
		}else{
			return null;
		}
	}
	private boolean isInteger(String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException n){
			return false;
		}
	}
}