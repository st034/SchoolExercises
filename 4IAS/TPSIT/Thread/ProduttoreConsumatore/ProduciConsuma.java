
/**
 * Aggiungi qui una descrizione della classe ProduciConsuma
 * 
 * @author Kleb 
 * @version 0
 */
public class ProduciConsuma{
    Object svuotato = new Object();
    Boolean riempito = new Boolean(true);
    Integer buffer;
    public synchronized Boolean getCondition(){
        return riempito;
    }
    public void setCondition(){
        synchronized(svuotato){
            riempito=false;
            svuotato.notify();
        }
    }
    public void metti(int el){
        try{
            synchronized(svuotato){
                if(buffer!=null&&riempito){
                    System.out.println("metti: buffer pieno, attendo...");
                    svuotato.wait();
                }
            }
            synchronized(riempito){
                buffer = el;
                System.out.println("metti: inserito "+el+" nel buffer");
                riempito.notify();
                System.out.println("metti: notifico che il dato "+buffer+" è stato inserito");
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public int preleva(){
        try{
            synchronized(riempito){
                if(buffer==null){
                    System.out.println("preleva: buffer vuoto, attendo...");
                    riempito.wait();
                }
            }
            synchronized(svuotato){
                int tmp=buffer;
                System.out.println("preleva: dato "+buffer+" consumato");
                buffer=null;
                System.out.println("preleva: notifico che il buffer è vuoto");
                svuotato.notify();
                return tmp;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
