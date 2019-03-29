public class Bevitore extends Thread{
    BotteDiVino botte;
    String nome;
    public Bevitore(BotteDiVino botte, String name){
        this.botte=botte;
        this.start();
        nome=name;
    }
    public void run(){
        while(true){
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            botte.bevi(nome);
            if(botte.getCondition()){
                break;
            }
        }
    }
}
        