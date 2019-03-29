package Bagno2;

public class Main{
    public static void main(String[] args){
        Bagno b=new Bagno();
        Persona[] p=new Persona[5];
        for(int i=0; i<5; i++){
            p[i]=new Persona(b,"p"+(i+1));
        }
        for(int i=0; i<5; i++){
            try{
                p[i].join();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}