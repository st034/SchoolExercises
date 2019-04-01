import java.util.LinkedList;
public class List{
    long count=0;
    LinkedList<Integer> list;
    public List(){
        list=new LinkedList();
    }
    public void add(int index, Integer el){
        list.add(index, el);
    }
    public Integer get(int index){
        return list.get(index);
    }
    public int findPosition(Integer el){
        int cnt=0;
        if(list.isEmpty()){
            return 0;
        }else{
            do{
                if(list.get(cnt) > el){
                    return cnt;
                }
                cnt++;
            }while(cnt<list.size());
            return list.size();
        }
    }
    public void insertOrder(Integer el){
        int tmp=findPosition(el);
        count+=tmp;
        add(tmp, el);
    }
    public void resetCount(){
        count=0;
    }
    public void incrementCount(){
        count++;
    }
    public long getCount(){
        return count;
    }
}