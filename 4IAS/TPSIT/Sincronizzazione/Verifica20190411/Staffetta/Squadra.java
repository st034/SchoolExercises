
public class Squadra extends Thread{
    private String name;
    private int number;
    Corridore[] squadra;

    public Squadra(String name, int number, int length){
        this.name=name;
        this.number=number;
        squadra = new Corridore[length];
        for (int i = 0; i < squadra.length; i++){
            squadra[i] = new Corridore(i + 1);
        }
    }
    public void run(){
        for (int i = 0; i < squadra.length; i++){
            squadra[i].start();
            System.out.println("Squadra "+name+": "+"corridore "+squadra[i].number+" partito");
            try{
                squadra[i].join();
            } catch (InterruptedException k) {System.out.println(k);}
            if(squadra[i].getRandom()>980){
                System.out.println("Il corridore n°"+squadra[i].number+ " della squadra "+name+" e' caduto!");
            }
            System.out.println("Squadra "+name+": "+"corridore "+squadra[i].number+" passa il testimone");
        }
        System.out.println("Squadra "+name+": fine gara");
    }
    public int getNumber(){
        return number;
    }
    public String getNome(){
        return name;
    }

    public String toString(){ return "Squadra n°"+number+" \""+name+"\";"; }
}
