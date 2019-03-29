
public class List<T> {
	private Nodo<T> head;
	private Nodo<T> tail;
    public List() {
    	head=null;
    	tail=null;
    }
    public void add(T info){
    	if(isEmpty()){
    		head=new Nodo<T>(info, null);
    		tail=head;
    	}else{
    		tail.next=new Nodo(info,null);
    		tail=tail.next;
    	}
    }
    public T get(int index) throws NullPointerException{
    	if(isEmpty()){
    		throw new NullPointerException("Lista Vuota");
    	}else{
			Nodo<T> tmp=head;
			return get(index, tmp);
    	}
    }
    private T get(int index, Nodo<T> tmp){
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
    public boolean isEmpty(){
    	return head==null&&tail==null;
    }
    public void insertInSecondPosition(T el)throws NullPointerException{
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
    public int find(T el){
    	Nodo<T> tmp=head;
    	return find(el, tmp, 0);
    }
    private int find(T el, Nodo<T> tmp, int index){
    	if(tmp.info.equals(el)){
    		return index;
    	}else{
    		return find(el,tmp.next,index+1);
    	}
    }
    public int noOfOccurences(T el){
    	Nodo<T> tmp=head;
    	return noOfOccurences(el, tmp, 0);
    }
    private int noOfOccurences(T el, Nodo<T> tmp, int index){
    	if(tmp==null){
    		return index;
    	}else{
    		if(tmp.info.equals(el)){
    			index++;
    		}
    		return noOfOccurences(el,tmp.next,index);
    	}
    }
    /*public T findMax(){
    	Nodo<T> tmp=head;
    	if(isEmpty()){
    		return null;
    	}else if(head==tail){
    		return tmp.info;
    	}else{
    		return findMax(tmp,tmp.info);
    	}
    }*/
    /*private T findMax(Nodo<T> tmp, T max){
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
    }*/
}
class Main{
	public static void main(String[] args){
		List<Integer> list=new List<>();
		for(int i=0; i<10; i++){
			list.add(i);
		}
		for(int i=0; i<10; i++){
			System.out.println(list.get(0));
			list.remove();
		}
		list.add(16);
		list.add(12);
		list.insertInSecondPosition(32);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.noOfOccurences(12));
	}
}