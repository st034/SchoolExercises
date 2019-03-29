public class Produttore extends Thread{
	String nome;
	ProduciConsuma monitor;
	public Produttore(String nome, ProduciConsuma monitor){
		this.nome=nome;
		this.monitor=monitor;
	}
	public void run(){
		int tmp;
		do{
			tmp=(int)(Math.random()*20);
			if(tmp!=5){
				monitor.metti(tmp);
				System.out.println("Produttore "+nome+" produce: "+tmp);
			}else{
				break;
			}
		}while(true);
	}
}