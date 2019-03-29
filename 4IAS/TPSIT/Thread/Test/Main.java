public class Main{
    public static void main(String[] args){
        Museo m=new Museo();
        Turista[] turisti= new Turista[50];
        for(int i=0; i<50; i++){
            turisti[i]=new Turista("turista "+(i+1), m);
        }
        for(int i=0; i<50; i++){
            try{
                turisti[i].join();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}