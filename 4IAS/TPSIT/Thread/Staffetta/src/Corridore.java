public class Corridore extends Thread{
    private long partenza;
    private long time=0;
    private long rand;
    private int number;

    public Corridore(int number){
        this.number = number;
    }
    public void run(){
        riceviTestimone();
        if(!corri()){
            long rand=(long)(Math.random()*10000);
            passaTestimone();
            time=rand;
        }else{
            passaTestimone();
        }
    }
    private void riceviTestimone(){
        partenza=System.currentTimeMillis();
    }
    private boolean corri(){
        rand=(long)(Math.random()*1000);
        try{
            if(rand<980) {
                Thread.sleep(rand);
            }else{
                return false;
            }
        }catch (InterruptedException e){return false;}
        return true;
    }
    private void passaTestimone(){
        time=time+(System.currentTimeMillis()-partenza);
    }
    public long getTime(){
        return time;
    }
    public long getRandom(){
        return rand;
    }
    public void setTime(long time){
        this.time=time;
    }
}
