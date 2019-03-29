
/**
 * Aggiungi qui una descrizione della classe Consumatore
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Consumatore extends Thread{
    ProduciConsuma monitor;
    public Consumatore(ProduciConsuma monitor){
        this.monitor=monitor;
    }
    public void run(){
        int dato;
        do{
            dato=monitor.preleva();
            if(dato==5){
                System.out.println("consumatore: il dato "+dato+" è danneggiato, mi fermo");
                monitor.setCondition();
                break;
            }
        }while(true);
    }
}
