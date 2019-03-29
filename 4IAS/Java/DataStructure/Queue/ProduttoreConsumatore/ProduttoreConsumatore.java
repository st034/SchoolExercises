
public class ProduttoreConsumatore extends Thread{
	private static CodaCircolare prodotti=new CodaCircolare(100);
	private boolean isProd;
	public static String stringaFinale="";
	
	public ProduttoreConsumatore(boolean isProd){
		this.isProd=isProd;
	}
	public void run(){
		for(int i=0;i<500;i++){
			if(isProd){
				produci();
			}else{
				consuma();
			}
		}
	}
	public void produci(){
		boolean notReady=false;
		do{
			int n=(int)(Math.random()*20);
			try{
				prodotti.enqueue(n);
				try{
					Thread.sleep((int)(Math.random()*1000));
				}catch(Exception e){
					throw new RuntimeException(e);
				}
				/*synchronized(this){
					stringaFinale+="Prodotto: "+n+"\n";
				}*/
				System.out.println("Prodotto: "+n);
				//System.out.println(stringaFinale);
				notReady=false;
			}catch(Exception e){
				notReady=true;
				try{
					Thread.sleep(2000);
				}catch(Exception f){
					throw new RuntimeException(f);
				}
			}
		}while(notReady);
	}
	public void consuma(){
		boolean notReady=false;
		do{
			try{
				/*synchronized(this){
					stringaFinale+="Consumato: "+prodotti.dequeue()+"\n";
				}*/
				System.out.println("Consumato: "+prodotti.dequeue());
				//System.out.println(stringaFinale);
				try{
					Thread.sleep((int)(Math.random()*1000));
				}catch(Exception e){
					throw new RuntimeException(e);
				}
				notReady=false;
			}catch(Exception e){
				notReady=true;
				try{
					Thread.sleep(2000);
				}catch(Exception f){
					throw new RuntimeException(f);
				}
			}
		}while(notReady);
	}
	public static String getStringaFinale(){
		return stringaFinale;
	}
}