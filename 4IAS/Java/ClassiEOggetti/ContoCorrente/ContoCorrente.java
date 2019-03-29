/**
 * @(#)Text1.java
 *
 *
 * @author
 * @version 1.00 2018/10/22
 */


public class ContoCorrente {

	private double saldo=0;
	private String nome;

    public ContoCorrente(String name, double s) {
    	nome=name;
    	saldo=s;
    }
    public ContoCorrente(String name){
    	nome=name;
    }
    public void deposita(double n){
    	saldo+=n;
    }
    public boolean preleva(double n){
    	if(saldo<n){
    		return false;
    	}else{
    		saldo-=n;
    		return true;
    	}
    }
    public static boolean trasferisci(ContoCorrente mittente, ContoCorrente destinatario, double n){
    	if(mittente.saldo<n){
    		return false;
    	}else{
    		mittente.saldo-=n;
    		destinatario.saldo+=n;
    		return true;
    	}
    }
    public String toString(){
    	return "Saldo disponibile: "+saldo+".";
    }
    public String name(){
    	return nome;
    }
}