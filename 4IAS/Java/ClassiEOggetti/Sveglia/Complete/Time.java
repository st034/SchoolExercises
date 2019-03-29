
public class Time {
	protected int ore, minuti;
	//costruttore completo
    public Time(int pOre, int pMinuti) {
    	ore=pOre;
    	minuti=pMinuti;
    }
    //costruttore base
    public Time(){
    	ore=0;
    	minuti=0;
    }
    public boolean equals(Time t){
    	return ore==t.ore&&minuti==t.minuti;
    }
    public Time copy(){
    	return new Time(ore, minuti);
    }
    public String toString(){
    	return ore+":"+minuti;
    }
    //incrementa minuti
    public void incMinuti(){
    	minuti++;
    	if(minuti==60){//se i minuti sono 60 si setta l'attributo minuti a 0 e si incrementano le ore
    		minuti=0;
    		ore++;
    		if(ore==24){//se le ore sono 24 si settano a 0
    			ore=0;
    		}
    	}
	}
}
