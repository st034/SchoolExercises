public class Parcheggio{
	int postiLiberi=5;
	Object libero=new Object();
	Object occupato=new Object();
	public void occupa(String nome){
		try{
			synchronized(occupato){
				while(postiLiberi==0){
					System.out.println(nome+" Parcheggio pieno, attendo...");
					occupato.wait();
				}
				System.out.println(nome+" Occupo il posto");
				postiLiberi--;
			}
			synchronized(libero){
				libero.notify();
				System.out.println(nome+" Posti liberi adesso: "+postiLiberi);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public void libera(String nome){
		try{
			synchronized(libero){
				while(postiLiberi==4){
					System.out.println(nome+" Attendo che qualcuno entra nel parcheggio");
					libero.wait();
				}
			}
			synchronized(occupato){
				System.out.println(nome+" Libero il posto");
				postiLiberi++;
				occupato.notify();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}