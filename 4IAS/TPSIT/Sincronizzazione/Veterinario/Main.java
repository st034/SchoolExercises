public class Main{
    public static void main(String[] args){
        Studio s=new Studio();
        Cane[] cani=new Cane[100];
        Gatto[] gatti=new Gatto[200];
        for(int i=0; i<100; i++){
            cani[i]=new Cane(s,"cane"+(i+1));
        }
        for(int i=0; i<200; i++){
            gatti[i]=new Gatto(s,"gatto"+(i+1));
        }
    }
}