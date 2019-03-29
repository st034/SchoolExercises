public class Motorino {

	private String marca;
	private String colore;
	private	float capMax=50;
	private	float capAttuale=10;
	private	float kmLt=10;
	private	boolean isOn=false;

	Motorino(String pmarca, String pcol, float capm, float capatt, float kml, boolean isn){
		marca=pmarca;
		colore=pcol;
		capMax=capm;
		capAttuale=capatt;
		kmLt=kml;
		isOn=isn;
	}
	Motorino(String pMarca, String pColore){
		marca=pMarca;
		colore=pColore;
	}
	Motorino(Motorino m){
		this(m.marca, m.colore, m.capMax, m.capAttuale, m.kmLt, m.isOn);
	}

	/*Motorino copy(){
		/*Motorino m=new Motorino("bmw","verde");
		m.capAttuale=this.capAttuale;
		m.capMax=this.capMax;
		m.kmLt=this.kmLt;
		m.marca=this.marca;
		m.colore=this.colore;

		return new Motorino(
											this.capAttuale,
											this.capMax,
											this.kmLt,
											this.marca,
											this.colore);
	}*/
	boolean equals(Motorino m){
		return this.capAttuale==m.capAttuale&&this.capMax==m.capMax&&this.kmLt==m.kmLt&&this.marca==m.marca&&this.colore==m.colore;
	}
	void mostraSpecifiche(){
		System.out.println(marca);
		System.out.println(colore);
		System.out.println(capAttuale);
	}
	void accendi(){
		isOn=true;
		System.out.println("Moto accesa.");
	}
	void spegni(){
		isOn=false;
		System.out.println("Moto spenta.");
	}
	void mostraCapacita(){
		System.out.println("Attualmente ci sono "+capAttuale+" lt nel serbatoio");
	}
	void rifornisci(float lt){
		if((lt+capAttuale)>capMax){
			System.out.println("Hai rifornito troppo, hai sprecato "+((lt+capAttuale)-capMax)+" lt.");
			capAttuale=capMax;
		}else{
			capAttuale=lt+capAttuale;
		}
	}
	void viaggia(float km){
		if(isOn){
			float x=capAttuale-(km/kmLt);
			if(x<0){
				System.out.println("La moto si è fermata e necessita rifornimento.");
			}else{
				capAttuale=x;
			}
		}else{
			System.out.println("Devi accendere la moto!");
		}
	}
	boolean isOn(){
		return isOn;
	}
}
