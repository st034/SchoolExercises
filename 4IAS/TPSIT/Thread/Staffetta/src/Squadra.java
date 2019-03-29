import java.awt.image.BufferedImage;
import java.io.*;
public class Squadra extends Thread implements Comparable<Squadra>{
    private long time=0;
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
            try{
                squadra[i].join();
            } catch (InterruptedException k) {System.out.println(k);}
            time = squadra[i].getTime();
            if(squadra[i].getRandom()>980){
                System.out.println("Il corridore n°"+(i+1)+ " della squadra "+name+" è caduto!");
            }
            if (i < squadra.length - 1){
                squadra[i + 1].setTime(time);
            }
        }
    }
    public int getNumber(){
        return number;
    }
    public long getTime(){
        return time;
    }
    public String getNome(){
        return name;
    }

    @Override
    public int compareTo(Squadra e){
        return (int)(this.time-e.time);
    }
    public String toString(){ return "Squadra n°"+number+" \""+name+"\";"; }
}
