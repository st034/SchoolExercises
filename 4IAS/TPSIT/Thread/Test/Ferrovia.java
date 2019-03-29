public class Ferrovia{
    public static void main(String[] args){
        Ponte p=new Ponte();
        Treno t1=new Treno(p, "tito");
        Treno t2=new Treno(p, "GIGI");
        try{
            t1.join();
            t2.join();
        }catch(Exception e){}
    }
}