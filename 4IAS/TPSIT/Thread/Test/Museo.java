public class Museo{
    Integer posti;
    public Museo(){
        posti=new Integer(0);
    }
    public synchronized void entra(String nome){
        while(posti==5){
            try{
                System.out.println(nome+": aspetto il mio turno.");
                this.wait();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println(nome+": entro nel museo.");
        posti++;
    }
    public void guarda(String nome){
        try{    
            System.out.println(nome+": guardo il quadro.");
            Thread.sleep(500);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public synchronized void esci(String nome){
        System.out.println(nome+": esco dal museo.");
        posti--;
        this.notify();
    }
}