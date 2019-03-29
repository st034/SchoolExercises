
public class Main{
	public static void main(String[] args){
		ProduttoreConsumatore produttore=new ProduttoreConsumatore(true);
		ProduttoreConsumatore consumatore=new ProduttoreConsumatore(false);

		produttore.start();
		consumatore.start();
		System.out.println("Iniziato");
		try{
	 		produttore.join();
	 		System.out.println("produttore ok");
	 		consumatore.join();
	 		System.out.println("consumatore ok");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		System.out.println(ProduttoreConsumatore.getStringaFinale());
	}
}