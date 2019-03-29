/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/1/22
 */


public class Cassa extends Thread{
	public Cinema c;
	public static int numeroCasse=0;
	public int cassaNumero=0;
    public Cassa(Cinema c) {
    	this.c=c;
    	cassaNumero=numeroCasse++;
    }
    public void run(){
    	int posti;
    	int residui=c.postiLiberi;
    	while(residui>0){
    		posti=1+(int)(Math.random()*3);
    		residui=c.vendiPosti(posti,cassaNumero);
    		try{
    			Thread.sleep(500+(int)(Math.random()*1500));
    		}catch(Exception e){
    			throw new RuntimeException(e);
    		}
    		
    	}
    }    
}
class Cinema{
	public int postiLiberi;
	public int postiVenduti=0;
	public Cinema(int posti){
		postiLiberi=posti;
	}
	public int vendiPosti(int numeroPosti, int cassaNumero){
		if(postiLiberi>=numeroPosti){
			System.out.println("Posti venduti "+numeroPosti+"/"+postiLiberi+" dalla cassa "+cassaNumero);
			postiLiberi-=numeroPosti;
			postiVenduti+=numeroPosti;
		}else{
			System.out.println("Posti non disponibili");
		}
		return postiLiberi;
	}
	public static void main(String[] args){
		Cinema c=new Cinema(150);
		Cassa[] casse=new Cassa[20];
		for(int i=0; i<casse.length;i++){
			casse[i]=new Cassa(c);
		}
		for(int i=0; i<casse.length;i++){
			casse[i].start();
		}
		try{
			for(int i=0; i<casse.length;i++){
				casse[i].join();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		System.out.println("Posti venduti "+c.postiVenduti);
	}
}