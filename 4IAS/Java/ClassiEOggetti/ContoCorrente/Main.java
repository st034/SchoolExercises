import java.util.*;


public class Main {

    public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);

    	ContoCorrente it01113=new ContoCorrente("Giorgio", 3000);
    	ContoCorrente it01114=new ContoCorrente("Luca");

    	System.out.println("Ciao "+it01113.name()+", inserisci l'importo da prelevare: ");
    	double n=scn.nextDouble();

    	if(it01113.preleva(n)){
    		System.out.println("Operazione effettuata con successo");
    	}else{
    		System.out.println("Operazione non riuscita, saldo non disponibile");
    	}

		System.out.println("Ciao "+it01113.name()+", inserisci l'importo da trasferire a "+it01114.name()+": ");
    	n=scn.nextDouble();

    	if(ContoCorrente.trasferisci(it01113, it01114, n)){
    		System.out.println("Operazione effettuata con successo");
    	}else{
    		System.out.println("Operazione non riuscita, saldo non disponibile");
    	}

		System.out.println("Conto it01113 - "+it01113.toString());
		System.out.println("Conto it01113 - "+it01114.toString());

    }


}