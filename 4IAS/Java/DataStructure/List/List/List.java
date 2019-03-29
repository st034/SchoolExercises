
public class List{
    Nodo head;
    Nodo tail;
    public List(){
        head=null;
        tail=null;
    }
    public int get(int pos){
        if(length()<pos){
            throw new NullPointerException("Posizione non trovata");
        }else if(isEmpty()){
            throw new NullPointerException("Lista vuota");
        }else{
            return get(head,pos);
        }
    }
    public void add(int pos, int el) throws NullPointerException{
        if(length()<pos){
            throw new NullPointerException("Posizione non trovata");
        }else if(isEmpty()){
            head=new Nodo(el, head);
            tail=head;
        }else if(head==tail&&head!=null){
            if(pos==0){
                head=new Nodo(el, head);
                tail=head.next;
            }else{
                head.next=new Nodo(el, head.next);
                tail=head.next;
            }
        }else if(pos==0){
            head=new Nodo(el, head);
        }else{
            add(head, pos-1, el);
        }
    }
    public boolean isEmpty(){
        return head==null&&tail==null;
    }
    public int length(){
        return length(head,0);
    }
    public boolean exists(int el){
        if(isEmpty()){
            throw new NullPointerException("Lista vuota");
        }else{
            return exists(head, el);
        }
    }
    public int findPosition(int el) throws Exception{
        if(isEmpty()){
            return 0;
        }else{
            return findPosition(head, 0, el);
        }
    }
    public void insertOrder(int el){
        Nodo tmp=head;
        if(isEmpty()){
            head=new Nodo(el, head);
            tail=head;
        }else if(head==tail&&head!=null){
            if(tmp.info>el){
                head=new Nodo(el, head);
                tail=head.next;
            }else{
                head.next=new Nodo(el, head.next);
                tail=head.next;
            }
        }else{
            do{
                if(tmp.info>el){
                    tmp=new Nodo(el, tmp);
                    break;
                }
                tmp=tmp.next;
            }while(tmp.next!=null);
            tmp.next=new Nodo(el, tmp.next);
        }
    }
    private void add(Nodo tmp, int pos, int el){
        for(int i=0; i<pos; i++){
            tmp=tmp.next;
        }
        tmp.next=new Nodo(el, tmp.next);
    }    
    private int length(Nodo tmp, int count){
        if(tmp==null){
            return count;
        }else{
            return length(tmp.next, count+1);
        }
    }    
    private int findPosition(Nodo tmp, int count, int el){
        if(tmp==null){
            return count;
        }else{
            if(tmp.info>=el){
                return count;
            }else{
                return findPosition(tmp.next, count+1, el);
            }
        }
    }
    private int get(Nodo tmp, int pos){
        if(pos==0){
            return tmp.info;
        }else{
            return get(tmp.next, pos-1);
        }
    }
    private boolean exists(Nodo tmp, int el){
        if(tmp==null){
            return false;
        }if(tmp.info==el){
            return true;
        }else{
            return exists(tmp.next, el);
        }
    }    
}
