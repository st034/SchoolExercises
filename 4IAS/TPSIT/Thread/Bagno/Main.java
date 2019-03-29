
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main{
    public static void main(String[] args){
        Bagno monitor=new Bagno();
        Persona[] p1=new Persona[3];
        System.out.println("inizio");
        for(int i=0; i<3; i++){
            p1[i]=new Persona(monitor, "p"+(i+1));
        }
        for(int i=0; i<3; i++){
            try{
                p1[i].join();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("fine");
    }
}
