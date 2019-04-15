public class Auto extends Thread{
	private Parcheggio p;
	private String nome;
	public Auto(Parcheggio m, String nome){
		p=m;
		this.nome=nome;
		this.start();
	}
	public void run(){
		for(int i=0; i<5; i++){
			p.occupa(nome);
			try{
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			p.libera(nome);
		}
	}
}