import java.util.Iterator;
public class AlberoIterator implements Iterator{
	Stack<Node> stack;
	Node root;
	public AlberoIterator(AlberoIterable tree){
		root = tree.root;
		stack = new Stack();
		fillStack(root);
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public Object next(){
		return stack.pop().info;
	}
	private void fillStack(Node root){
		if(root!=null){
			if(root.dx!=null){fillStack(root.dx);}
			stack.push(root);
			if(root.sx!=null){fillStack(root.sx);}
		}
	}
}