
/**
 * Aggiungi qui una descrizione della classe Produttore
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Produttore extends Thread{
    ProduciConsuma monitor;
    public Produttore(ProduciConsuma monitor){
        this.monitor=monitor;
    }
    public void run(){
        int dato;
        do{
            dato=1+(int)(Math.random()*99);
            monitor.metti(dato);
            if(dato==5){
                break;
            }
        }while(monitor.getCondition());
    }
}
