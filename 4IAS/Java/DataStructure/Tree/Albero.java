public class Albero{
	Nodo root;
	public Albero(){
		root=null;
	}
	public void insertElement(int info){
		if(root==null){
			root=new Nodo(info, null, null);
		}else{
			insertElement(info, root);
		}
	}
	private void insertElement(int info, Nodo tmp){
		if(info<tmp.info){
			if(tmp.sx==null){
				tmp.sx=new Nodo(info, null, null);
			}else{
				insertElement(info, tmp.sx);
			}
		}else{
			if(tmp.dx==null){
				tmp.dx=new Nodo(info, null, null);
			}else{
				insertElement(info, tmp.dx);
			}
		}
	}
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Nodo tmp){
		if(tmp!=null){
			inOrder(tmp.sx);
			System.out.println(tmp.info);
			inOrder(tmp.dx);
		}
	}
	public void postOrder(){
		postOrder(root);
	}
	private void postOrder(Nodo tmp){
		if(tmp!=null){
			postOrder(tmp.sx);
			postOrder(tmp.dx);
			System.out.println(tmp.info);
		}
	}
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Nodo tmp){
		if(tmp!=null){
			System.out.println(tmp.info);
			preOrder(tmp.sx);
			preOrder(tmp.dx);
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
}