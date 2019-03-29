/**
 * @(#)Main.java
 *
 *
 * @author
 * @version 1.00 2018/10/22
 */


public class Main {

    public static void main(String[] args) {
    	ContoCorrente it01113=new ContoCorrente("Giorgio", 3000);
    	ContoCorrente it01114=new ContoCorrente("Luca");
    	if(it01113.preleva(3001)){
    		System.out.println("Operazione effettuata con successo");
    	}else{
    		System.out.println("Operazione non riuscita, saldo non disponibile");
    	}

    	ContoCorrente.trasferisci(it01113, it01114, 1000);

		System.out.println("Conto it01113 - "+it01113.toString());
		System.out.println("Conto it01113 - "+it01114.toString());

    }


}