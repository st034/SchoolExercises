
public class Albero{
	Node root;
	public Albero(){
		root=null;
	}
	public void insertElement(int info){
		if(root==null){
			root=new Node(info, null, null);
		}else{
			insertElement(info, root);
		}
	}
	private void insertElement(int info, Node root){
		if(info<root.info){
			if(root.sx==null){
				root.sx=new Node(info, null, null);
			}else{
				insertElement(info, root.sx);
			}
		}else{
			if(root.dx==null){
				root.dx=new Node(info, null, null);
			}else{
				insertElement(info, root.dx);
			}
		}
	}
	public boolean exists(int el){
		if(isEmpty()){
			throw new NullPointerException("Tree empty");
		}else{
			return exists(el, root);
		}
	}
	private boolean exists(int el, Node root){
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
}