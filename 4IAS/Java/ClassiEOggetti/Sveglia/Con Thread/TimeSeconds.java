
class TimeSeconds extends Time{
	private int secondi;
	//costruttore completo
	public TimeSeconds(int pHour, int pMinute, int pSecond){
		super(pHour, pMinute);
		secondi=pSecond;
	}
	//costruttore base
	public TimeSeconds(){
		super();
		secondi=0;
	}
	//metodo per incremntare i secondi
	public void incSeconds(){
		secondi++;
		if(secondi==60){//se secondi raggiunge 60 si setta a 0 ed incrementa i minuti(vedi metodo incMinuti nella classe Time)
			super.incMinuti();
			secondi=0;
		}
	}
	public String toString(){//richiama il metodo madre toString e aggiunge i secondi
		return super.toString()+":"+secondi;
	}		
}