
/**
 * Aggiungi qui una descrizione della classe Main
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Main
{
    public static void main(String[] args){
        ProduciConsuma monitor = new ProduciConsuma();
        Produttore p1 = new Produttore(monitor);
        Consumatore c1 = new Consumatore(monitor);
        System.out.println("inizio");
        p1.start();
        c1.start();
        
        try{
            p1.join();
            c1.join();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("fine");
    }
}
