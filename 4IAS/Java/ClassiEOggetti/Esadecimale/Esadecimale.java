/**
 * @(#)Esadecimale.java
 *
 *
 * @author
 * @version 1.00 2018/11/7
 */


public class Esadecimale {
	private int numInt;
	private String numHex;
	private String[] character={"A","B","C","D","E","F"};

    public Esadecimale(int n) {
    	numInt=n;
    }

	public String toHex(){
		int ris=numInt, rest;
		String hex="";
		do{
			rest=ris%16;
			ris=ris/16;
			System.out.println(ris+"    "+rest);
			if(rest>=10){
				hex+=character[rest%10];
			}else{
				hex+=Integer.toString(rest);
			}
		}while(ris!=0);
		StringBuilder sb= new StringBuilder(hex);
		hex= sb.reverse().toString();
		return hex;
	}
	public static void main(String[] args){
		Esadecimale h1=new Esadecimale(20);
		String hex=h1.toHex();
		System.out.println(hex);
	}
}