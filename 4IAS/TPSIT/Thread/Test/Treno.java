public class Treno extends Thread{
    Ponte monitor;
    String nome;
    public Treno(Ponte m, String n){
        monitor=m;
        nome=n;
        start();
    }
    public void run(){
        while(true){

            try{
                monitor.p(nome);
                Thread.sleep(1000);
                monitor.v(nome);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}

    