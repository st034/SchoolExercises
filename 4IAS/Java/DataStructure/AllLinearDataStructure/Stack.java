public class Stack {
    Nodo head;
    public Stack(){
        head=null;
    }
    public void push(int el){
        head=new Nodo(el, head);
    }
    public int pop(){
        if(isEmpty()){
            throw new NullPointerException("Stack vuoto");
        }else{
            int tmp=head.info;
            head=head.next;
            return tmp;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public int getBefLastEl(){
        Nodo tmp=head;
        for(int i=0; i<size()-2;i++){
            tmp=tmp.next;
        }
        return tmp.info;
    }
    public int size(){
        int cnt=0;
        Nodo tmp=head;
        while(tmp!=null){
            cnt++;
            tmp=tmp.next;
        }
        return cnt;
    }
}