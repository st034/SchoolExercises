/**
 * @(#)Text4.java
 *
 *
 * @author 
 * @version 1.00 2018/12/23
 */


public class Scommessa{
	int[] bet;
	boolean vittoria;
    public Scommessa(int length) {
    	bet=new int[length];
    }
    public void setBet(int numero, int index){
    	bet[index]=numero;
    }
    public boolean checkScommessa(Cavallo[] ris){
    	int i=0;
    	vittoria=true;
    	do{
    		if(ris[i].getNumber()!=bet[i]){
				vittoria=false;
    		}
    		i++;
    	}while(vittoria||i==bet.length-1);
    	return vittoria;
    }
    public int getLength(){
    	return bet.length;
    }
    
    
}