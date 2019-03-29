public ProduciConsuma{
	
	public static void main(String[] args){
		ProduciConsuma monitor = new ProduciConsuma();
		Produttore p1=new Produttore("th1", monitor);
		Produttore p2=new Produttore("th2", monitor);
		p1.start();
		p2.start();
		
		try{
			p1.join();
			p2.join();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}