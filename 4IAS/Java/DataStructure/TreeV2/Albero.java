
public class Albero{
	Node root;
	public Albero(){
		root	=	new Node("*",
						new Node("+",
							new Node("6", null, null),
							new Node("+",
								new Node("4", null, null),
								new Node("2", null, null)
							)
						),
						new Node("+",
							new Node("4", null, null),
							new Node("5", null, null)
						)
					);
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