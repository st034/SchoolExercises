public class Corridore extends Thread{
    private long partenza;
    private long rand;
    public int number;

    public Corridore(int number){
        this.number = number;
    }
    public void run(){
        corri();
    }
    private boolean corri(){
        rand=(long)(Math.random()*1000);
        try{
			Thread.sleep(rand);
        }catch (InterruptedException e){return false;}
        return true;
    }
    public long getRandom(){
        return rand;
    }
}
