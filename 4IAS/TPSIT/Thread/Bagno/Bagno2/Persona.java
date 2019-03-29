package Bagno2;
public class Persona extends Thread{
    Bagno monitor;
    String nome;
    public Persona(Bagno m, String nome){
        monitor=m;
        this.nome=nome;
        this.start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            try{
                monitor.utilizza(nome);
                
                Thread.sleep(500);
                monitor.libera(nome);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}