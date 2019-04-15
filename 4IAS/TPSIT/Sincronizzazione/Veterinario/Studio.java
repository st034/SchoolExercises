public class Studio{
    int posti=5;
    Object cond=new Object();
    public void libera(String nome){
        synchronized(cond){    
            System.out.println(nome+" libero il posto");
            posti++;
            cond.notify();
        }
    }
    public void occupa(String nome){
        synchronized(cond){
            try{
                while(posti==0){
                    System.out.println(nome+" posti occupati, attendo");
                    cond.wait();
                }
                System.out.println(nome+" occupo il posto");
                posti--;
                System.out.println("posti liberi: "+posti);
            }catch(Exception e){}
        }
    }
}