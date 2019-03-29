public class Main{
    public static void main(String[] args){
        Stack s=new Stack();
        for(int i=1;i<=100;i++){
            s.push(i);
        }
        System.out.println(s.getBefLastEl());
        System.out.println(s.size());
    }
}