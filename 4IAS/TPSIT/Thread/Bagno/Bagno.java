public class Bagno{
    Boolean occupato = new Boolean(false);
    public synchronized void occupa(String nome){
        while(occupato){
            System.out.println(nome+": bagno occupato, attendo");
            try{
                this.wait();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println(nome+": occupo il bagno");
        occupato=true;
    }
    public synchronized void libera(String nome){
        System.out.println(nome+": libero il bagno");
        occupato=false;
        this.notify();
    }
}