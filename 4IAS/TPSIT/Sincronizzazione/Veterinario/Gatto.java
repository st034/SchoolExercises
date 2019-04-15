public class Gatto extends Thread{
    Studio monitor;
    String nome;
    public Gatto(Studio m, String name){
        monitor=m;
        nome=name;
        this.start();        
    }
    public void run(){
        //while(true){
            monitor.occupa(nome);
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){}
            monitor.libera(nome);
        //}
    }
}