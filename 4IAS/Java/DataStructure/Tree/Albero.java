public class Albero{
	Nodo root;
	int count;
	public Albero(){
		root=null;
		count=0;
	}
	public void insertElement(int info){
		if(root==null){
			root=new Nodo(info, null, null);
		}else{
			insertElement(info, root);
		}
	}
	private void insertElement(int info, Nodo root){
		if(info<root.info){
			if(root.sx==null){
				root.sx=new Nodo(info, null, null);
			}else{
				insertElement(info, root.sx);
			}
		}else{
			if(root.dx==null){
				root.dx=new Nodo(info, null, null);
			}else{
				insertElement(info, root.dx);
			}
		}
	}
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Nodo root){
		if(root!=null){
			inOrder(root.sx);
			count++;
			inOrder(root.dx);
		}
	}
	public void postOrder(){
		postOrder(root);
	}
	private void postOrder(Nodo root){
		if(root!=null){
			postOrder(root.sx);
			postOrder(root.dx);
			System.out.println(root.info);
		}
	}
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Nodo root){
		if(root!=null){
			System.out.println(root.info);
			preOrder(root.sx);
			preOrder(root.dx);
		}
	}
	public boolean exists(int el){
		if(isEmpty()){
			throw new NullPointerException("Tree empty");
		}else{
			return exists(el, root);
		}
	}
	private boolean exists(int el, Nodo root){
		if(root==null){
			return false;
		}else if(root.info==el){
			return true;
		}else if(root.info>el){
			return exists(el, root.sx);
		}else{
			return exists(el, root.dx);
		}
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void resetCount(){
		count=0;
	}
	public void clearTree(){
		root=null;
	}
	public int depth(){
		if(root==null){
			return 0;
		}else{
			return depth(root);
		}
	}
	private int depth(Nodo root){
		if(root==null){
			return 0;
		}else{
			return 1+getGreater(depth(root.sx),depth(root.dx));
		}		
	}
	private int getGreater(int val1, int val2){
		if(val1>val2){
			return val1;
		}else{
			return val2;
		}
	}
	public int noOfElements(){
		if(root==null){
			return 0;
		}else{
			return noOfElements(root);
		}
	}
	private int noOfElements(Nodo root){
		if(root==null){
			return 0;
		}else{
			return 1+(noOfElements(root.sx)+noOfElements(root.dx));		
		}
	}
	public void bracketsPrint(){
		if(root==null){
			System.out.println("()");
		}else{
			System.out.print("(");
			bracketsPrint(root);
		}
	}
	private void bracketsPrint(Nodo root){
		System.out.print(root.info);
		if(root.sx!=null){
			System.out.print("(");
			bracketsPrint(root.sx);
		}else{
			System.out.print("(--");
		}
		if(root.dx!=null){
			System.out.print(", ");
			bracketsPrint(root.dx);
			System.out.print(")");
		}else{
			System.out.print(", --)");
		}
	}
	public void indentPrint(){
		if(root==null){
			System.out.println("Tree Empty");
		}else{
			indentPrint(root, 0);
		}
	}
	private void indentPrint(Nodo root, int space){
		System.out.println(root.info);
		if(root.sx!=null){
			for(int i=0; i<=space;i++){
				System.out.print("  ");
			}
			indentPrint(root.sx, space+1);
		}else{
			for(int i=0; i<=space;i++){
				System.out.print("  ");
			}
			System.out.println("--");
		}
		if(root.dx!=null){
			for(int i=0; i<=space;i++){
				System.out.print("  ");
			}
			indentPrint(root.dx, space+1);
		}else{
			for(int i=0; i<=space;i++){
				System.out.print("  ");
			}
			System.out.println("--");
		}
	}
}