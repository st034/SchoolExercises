/**
 * @(#)Prove.java
 *
 *
 * @author
 * @version 1.00 2018/10/26
 */
import java.util.*;

public class CrittografiaDiCesare {

    public static void main(String[] args) {

    	char[] caratteri = {' ','a','b','c','d','e','f','œ','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    								 '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    	Scanner scn=new Scanner(System.in);
    	System.out.println("Inserisci il testo: ");
    	String text = scn.nextLine();

    	char[] textChar = text.toCharArray();
		char[] textCharTranslated = new char[textChar.length];

    	System.out.println("Inserisci la chiave per criptare e decifrare il testo: ");
    	int key = scn.nextInt();


		for(int i=0; i<textChar.length;i++){
			for(int k=0; k<caratteri.length;k++){
				if(textChar[i]==caratteri[k]){
					textCharTranslated[i]=caratteri[(k+key)%caratteri.length];
					System.out.print(caratteri[(k+key)%caratteri.length]);
				}
			}
		}
		System.out.println();
		for(int i=0; i<textCharTranslated.length;i++){
			for(int k=0; k<caratteri.length;k++){
				if(k<key){
					if(textCharTranslated[i]==caratteri[k]){
						textChar[i]=caratteri[(k-key)+caratteri.length];
						System.out.print(caratteri[(k-key)+caratteri.length]);
					}
				}
				else if(k>=key){
					if(textCharTranslated[i]==caratteri[k]){
						textChar[i]=caratteri[(k-key)];
						System.out.print(caratteri[(k-key)]);
					}
				}
			}
		}
    }
}