public class BotteDiVino{
    int litri;
    int rubinetti;
    boolean isEmpty;
    public BotteDiVino(){
        litri=100;
        rubinetti=3;
        isEmpty=false;
    }
    public boolean isEmpty(){
        return litri==0;
    }
    public synchronized void bevi(String nome){
        while(rubinetti==0){
                try{
                    System.out.println(nome+": non c'è posto, attendo...");
                    this.wait();
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
        }
        if(isEmpty()){
            System.out.println(nome+": la botte è vuota");            
            setCondition();
        }else{
            rubinetti--;
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            litri--;
            System.out.println(nome+": bevo un bicchierozzo di vino, litri rimanenti: "+litri);
        }
        libera(nome);
    }
    public synchronized void libera(String nome){
        System.out.println(nome+": libero il posto");        
        rubinetti++;
        this.notify();
    }
    public synchronized void setCondition(){
        isEmpty=true;
    }   
    public synchronized boolean getCondition(){
        return isEmpty;
    }
}