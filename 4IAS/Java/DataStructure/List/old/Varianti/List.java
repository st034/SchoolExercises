
public class List {
	private Nodo head;
	private Nodo tail;
    public List() {
    	head=null;
    	tail=null;
    }
    public void add(int info){
    	if(isEmpty()){
    		head=new Nodo(info, null);
    		tail=head;
    	}else{
    		tail.next=new Nodo(info,null);
    		tail=tail.next;
    	}
    }
    public int get(int index) throws NullPointerException{
    	if(isEmpty()){
    		throw new NullPointerException("Lista Vuota");
    	}else{
			Nodo tmp=head;
			return get(index, tmp);
    	}
    }
    private int get(int index, Nodo tmp){
    	if(index==0){
    		return tmp.info;
    	}else{
    		return get(index-1,tmp.next);
    	}
    }
    public void remove() throws NullPointerException{
    	if(isEmpty()){
    		throw new NullPointerException("Lista vuota: nulla da rimuovere");
    	}else{
    		if(head.next==null){
    			head=null;
    			tail=null;
    		}else{
    			head=head.next;
    		}
    	}
    }
    public int length(){
    	if(isEmpty()){
    		return 0;
    	}else{
    		return length(head,0); 
    	}
    }
    private int length(Nodo tmp, int index){
    	if(tmp.next==null){
    		return index;
    	}else{
    		return length(tmp.next,index+1);
    	}
    }
    public void remove(int index) throws NullPointerException{
    	if(index>=0){
    		if(isEmpty()){
	    		throw new NullPointerException("lista vuota");
	    	}else{
	    		if(length()<index){
	    			throw new NullPointerException("Indice troppo grande");
	    		}else{
	    			if(index==0){
	    				if(head==tail){
	    					head=null;
	    					tail=null;
	    				}else{
	    					head=head.next;
	    				}
	    			}else{
	    				remove(head,index);
	    			}
	    		}
	    	}
    	}else{
    		throw new NullPointerException("Indice inserito è minore di 0");
    	}
    }
    private void remove(Nodo tmp, int index){
    	if(index==1){
    		if(tmp.next==tail){
    			tmp.next=null;
    			tail=tmp;
    		}else{
    			tmp.next=tmp.next.next;
    		}
    	}else{
    		remove(tmp.next,index-1);
    	}
    }
    public boolean isEmpty(){
    	return head==null&&tail==null;
    }
    public void insertInSecondPosition(int el)throws NullPointerException{
    	if(isEmpty()){
    		throw new NullPointerException("Lista vuota: non esiste seconda posizione");
    	}else{
    		if(head.next==null){
    			head.next=new Nodo(el,null);
    			tail=head.next;
    		}else{
    			head.next=new Nodo(el,head.next);
    		}
    	}
    }
    public int find(int el){
    	Nodo tmp=head;
    	return find(el, tmp, 0);
    }
    private int find(int el, Nodo tmp, int index){
    	if(tmp.info==el){
    		return index;
    	}else{
    		return find(el,tmp.next,index+1);
    	}
    }
    public int noOfOccurences(int el){
    	Nodo tmp=head;
    	return noOfOccurences(el, tmp, 0);
    }
    private int noOfOccurences(int el, Nodo tmp, int index){
    	if(tmp==null){
    		return index;
    	}else{
    		if(tmp.info==el){
    			index++;
    		}
    		return noOfOccurences(el,tmp.next,index);
    	}
    }
    public int findMax() throws NullPointerException{
    	Nodo tmp=head;
    	if(isEmpty()){
    		throw new NullPointerException("lista vuota");
    	}else if(head==tail){
    		return tmp.info;
    	}else{
    		return findMax(tmp,tmp.info);
    	}
    }
    private int findMax(Nodo tmp, int max){
    	if(tmp.next==null){
    		if(tmp.info>max){
    			return tmp.info;
    		}else{
    			return max;
    		}
    	}else{
    		if(tmp.info>max){
    			return findMax(tmp.next,tmp.info);
    		}else{
    			return findMax(tmp.next,max);
    		}
    	}
    }
    public boolean exist(int el){
    	return exist(head,el);
    }
    private boolean exist(Nodo tmp, int el){
    	if(tmp.next==null){
    		return tmp.info==el;
    	}else{
    		if(tmp.info==el){
    			return true;
    		}else{
    			return exist(tmp.next,el);
    		}
    	}
    } 
    public void insertAfter(int el, int newEl) throws NullPointerException{
    	if(isEmpty()){
    		throw new NullPointerException("Lista vuota");
    	}else{
    		if(exist(el)){
    			insertAfter(head, el, newEl);
    		}else{
    			throw new NullPointerException("Elemento non trovato");
    		}
    	}
    }
    private void insertAfter(Nodo tmp, int el, int newEl){
    	if(tmp.info==el){
    		if(tmp.next==null){
    			tmp.next=new Nodo(newEl, tmp.next);
    			tail=tmp.next;
    		}else{
    			tmp.next=new Nodo(newEl, tmp.next);
    		}
    	}else{
    		insertAfter(tmp.next, el, newEl);
    	}
    }
    public void insertOrder(int el){
    	insertPosition(findGreaterThan(el), el);
    }
    public void insertPosition(int pos, int el){
    	if(length()>=pos){
    		if(pos==0){
    			head=new Nodo(el, null);
    			tail=head;
    		}else if(pos==1){
    			head.next=new Nodo(el, head.next);
    			tail=head.next;
    		}else{
	    		insertPosition(head, pos, el);
    		}
    	}else{
    		throw new NullPointerException("Posizione non trovata");
    	}
    }
    private void insertPosition(Nodo tmp, int pos, int el){
    	if(pos==1){
    		tmp=new Nodo(el, tmp);
    	}else{
    		insertPosition(tmp.next, pos-1, el);
    	}
    }
    private int findGreaterThan(int el){
    	if(isEmpty()){
    		return 0;
    	}else if(head==tail&&head!=null){
    		if(head.info>el){
    			return 0;
    		}else{
    			return 1;
    		}
    	}else{
    		return findGreaterThan(el, head, 0);
    	}
    }
    private int findGreaterThan(int el, Nodo tmp, int cnt){
    	if(tmp==null){
    		return cnt;
    	}else{
    		if(tmp.info>el){
    			return cnt;
    		}else{
    			return findGreaterThan(el, tmp.next, cnt+1);
    		}
    	}
    }
}
class Main{
	public static void main(String[] args){
		List list=new List();
		for(int i=0; i<100; i++){
			list.insertOrder((int)(Math.random()*100));
			System.out.println(i);
		}
	}
}