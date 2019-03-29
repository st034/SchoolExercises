public class Ponte{
    boolean ponte=true;
    public synchronized void p(String nome){
        while(!ponte){
            try{
                System.out.println(nome+" ponte occupato attendo");
                this.wait();
            }catch(Exception e){}
        }
        System.out.println(nome+" occupo il ponte");
        ponte=false;
    }
    public synchronized void v(String nome){
        System.out.println(nome+" libero il ponte");
        ponte=true;
        this.notify();
    }
}
    