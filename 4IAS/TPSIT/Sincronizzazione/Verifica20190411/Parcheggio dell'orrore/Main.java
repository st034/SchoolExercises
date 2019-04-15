public class Main{
	public static void main(String[] args){
		Parcheggio p = new Parcheggio();
		Auto[] auto = new Auto[10];
		System.out.println("Posti liberi all'inizio: "+p.postiLiberi);
		for(int i=0; i<10; i++){
			auto[i] = new Auto(p,"auto"+(i+1));
		}
		for(int i=0; i<10; i++){
			try{
				auto[i].join();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		System.out.println("Posti liberi alla fine: "+p.postiLiberi);
	}
}