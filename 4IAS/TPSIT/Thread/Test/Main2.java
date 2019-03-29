public class Main2{
    public static void main(String[] args){
        BotteDiVino b=new BotteDiVino();
        Bevitore[] matti=new Bevitore[5];
        for(int i=0; i<5;i++){
            matti[i]=new Bevitore(b, "p"+(i+1));
        }
        for(int i=0; i<5;i++){
            try{
                matti[i].join();
            }catch(Exception e){}
        }
    }
}