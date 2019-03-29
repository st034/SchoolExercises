package Bagno2;

public class Bagno{
    boolean bagniLiberi=true;
    Object occupato=new Object();
    Object libero=new Object();
    
    public synchronized boolean isLibero(){
        return bagniLiberi;
    }
    public void utilizza(String nome){
        synchronized(occupato){
            while(!isLibero()){
                try{
                    System.out.println(nome+": Tutti i bagni sono occupati, attendo...");
                    occupato.wait();
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized(libero){
            bagniLiberi=false;
            System.out.println(nome+": Occupo un bagno");   
        }
    }
    public void libera(String nome){
        synchronized(occupato){
            System.out.println(nome+": Libero il bagno");
            occupato.notify();
        }
        synchronized(libero){
            bagniLiberi=true;
        }
    }
}