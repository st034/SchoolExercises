public class Staffetta {
    Squadra[] squadre;

    public Staffetta(){
        creaSquadre();
        System.out.println("iniziamo!");
        partenza();
        attesaFine();
    }
    private void stampaSquadre(){
        String tmp;
        for(int i=0; i<squadre.length; i++){
            System.out.println("Squadra n°"+squadre[i].getNumber()+" \""+squadre[i].getNome()+"\"");
        }
    }
    private void creaSquadre(){
        squadre = new Squadra[6];
        squadre[0]=new Squadra("puzzoni", 1,8);
        squadre[1]=new Squadra("cervelloni", 2,8);
        squadre[2]=new Squadra("mangioni", 3,8);
        squadre[3]=new Squadra("dormiglioni", 4,8);
        squadre[4]=new Squadra("malatucci", 5,8);
        squadre[5]=new Squadra("peterGriffin", 6,8);
    }
    private void partenza(){
        for(int i=0; i<squadre.length; i++){
            squadre[i].start();
        }
    }
    private void attesaFine(){
        for(int i=0; i<squadre.length; i++){
            try{
                squadre[i].join();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
