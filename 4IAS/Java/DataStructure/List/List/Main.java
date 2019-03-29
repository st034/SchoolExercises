
/**
 * Aggiungi qui una descrizione della classe Main
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Main{
    public static void main(String[] args){
        List list= new List();
        int times=100;
        long start;
        for(int j=0;j<4;j++){
            list=new List();
            start=System.currentTimeMillis();
            for(int i=0; i<times; i++){
                if(i>3){
                    list.insertOrder((int)(Math.random()*100));
                }
            }
            start=System.currentTimeMillis()-start;
            System.out.println(times+": "+start+"ms");
            times*=10;
        }   
    }
}
