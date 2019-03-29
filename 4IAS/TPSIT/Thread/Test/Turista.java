public class Turista extends Thread{
    String nome;
    Museo monitor;
    public Turista(String nome, Museo monitor){
        this.nome=nome;
        this.monitor=monitor;
        this.start();
    }
    public void run(){
        monitor.entra(nome);
        monitor.guarda(nome);
        monitor.esci(nome);
    }
}