public class Motorino {
	private int capAttuale=10;
	private int capMax=50;
	private int kmLt=3;

	int getCapAttuale(){
		return capAttuale;
	}
	void setCapAttuale(int litri){
		if(litri<=capMax&&litri>=0)){
			capAttuale=litri;
		}else{
			System.out.println("Operazione non eseguibile: dato inserito non accettato.");
		}
	}
}
