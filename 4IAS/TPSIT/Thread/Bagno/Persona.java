/**
 * Write a description of class Persona here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Persona extends Thread{
    Bagno monitor;
    String nome;
    public Persona(Bagno monitor, String nome){
        this.monitor=monitor;
        this.nome=nome;
        this.start();
    }
    public void run(){
        for(int i=0; i<10; i++){
            try{
                monitor.occupa(nome);
                Thread.sleep(500);
                monitor.libera(nome);
                //Thread.sleep(1000);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}
