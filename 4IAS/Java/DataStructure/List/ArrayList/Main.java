public class Main{
    public static void main(String[] args){
        List list= new List();
        int times=100;
        long start;
        for(int j=0;j<4;j++){
            start=System.currentTimeMillis();
            list=new List();
            for(int i=0; i<times; i++){
                list.insertOrder((int)(Math.random()*100));
            }
            start=System.currentTimeMillis()-start;
            System.out.println(times+": "+start+"ms");
            times*=10;
        }
    }
}