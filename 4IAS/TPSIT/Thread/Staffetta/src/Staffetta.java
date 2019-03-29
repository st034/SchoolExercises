public class Staffetta {
    Squadra[] squadre;
    int scommessa,vincitore;

    public Staffetta(){
        creaSquadre();
        scommessa();
        System.out.println("BENE INIZIAMO!");
        partenza();
        attesaFine();
        ordinaRisultato();
        stampaRisultato();
        vincitore=squadre[0].getNumber();
        checkVincita();
    }
    private void scommessa(){
        System.out.println("Inserisci il numero della squadra che secondo te vincerà!");
        System.out.println("Le squadre sono le seguenti");
        stampaSquadre();
        System.out.println("Bene, ora scegli: ");
        java.util.Scanner scn=new java.util.Scanner(System.in);
        scommessa=scn.nextInt();
        System.out.println("Hai scelto la squadra: "+squadre[scommessa-1].getNome());
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
    private void ordinaRisultato(){
        java.util.Arrays.sort(squadre);
    }
    private void stampaRisultato(){
        for(int i=0; i<squadre.length; i++){
            System.out.println("Squadra n°"+squadre[i].getNumber()+" \""+squadre[i].getNome()+"\": "+squadre[i].getTime()+" ms");
        }
    }
    private void checkVincita(){
        if(scommessa==vincitore){
            System.out.println("COMPLIMENTI, HAI VINTO 100 ESCORT IN GETTONI D'ORO!");
        }else{
            System.out.println("HAI PERSO! :)");
        }
    }
}
