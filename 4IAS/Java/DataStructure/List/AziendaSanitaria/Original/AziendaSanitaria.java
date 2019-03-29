
import java.util.ArrayList;
public class AziendaSanitaria {
    private ArrayList<Medico> medici;
    private ArrayList<Paziente> pazienti;
    
    public AziendaSanitaria(){
        medici=new ArrayList();
        pazienti=new ArrayList();
    }
    public Medico trovaMedico(String unNomeMedico) throws NullPointerException{
        for(int i=0; i<medici.size();i++){
            if(medici.get(i).getNominativo()==unNomeMedico){
                return medici.get(i);
            }
        }
        throw new NullPointerException("Medico non trovato");
    }
    public void aggMedico(String unNomeMedico) throws Exception{
        if(exists(unNomeMedico)){
            throw new Exception("Medico già esistente.");
        }else{
            medici.add(new Medico(unNomeMedico));
        }
    }
    public boolean exists(String unNomeMedico){
        for(int i=0; i<medici.size(); i++){
            if(medici.get(i).getNominativo()==unNomeMedico){
                return true;
            }
        }
        return false;
    }
    public void eliminaPaziente(int unNumeroTessera){
        pazienti.remove(trovaPosizionePaziente(unNumeroTessera));
    }
    public void aggPaziente(int unNumeroTessera, String unNomeMedico) throws Exception{
        if(exists(unNumeroTessera)){
            throw new Exception("Paziente già esistente.");
        }else{
            pazienti.add(new Paziente(unNumeroTessera, trovaMedico(unNomeMedico)));
        }
    }
    public boolean exists(int unNumeroTessera){
        for(int i=0; i<pazienti.size(); i++){
            if(pazienti.get(i).getTesseraSanitaria()==unNumeroTessera){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Paziente> listaMedico(String unNomeMedico) throws NullPointerException{
        ArrayList<Paziente> tmp=new ArrayList();
        for(int i=0; i<pazienti.size();i++){
            if(pazienti.get(i).getMedicoCurante().equals(trovaMedico(unNomeMedico))){
                tmp.add(pazienti.get(i));
            }
        }
        if(tmp.isEmpty()){
            throw new NullPointerException("Nessun paziente trovato per il medico: "+unNomeMedico);
        }else{
            return tmp;
        }
    }
    public Medico statMedico(){
        return medici.get(trovaIndiceMedicoIncasinato());
    }
    private int getNumPazienti(Medico m){
        int cnt=0;
        for(int i=0;i<pazienti.size();i++){
            if(m.getNominativo()==pazienti.get(i).getMedicoCurante().getNominativo()){
                cnt++;
            }
        }
        return cnt;
    }
    private int trovaIndiceMedicoIncasinato(){
        int max=0;
        int tmp;
        Integer indiceMax=null;
        for(int i=0; i<medici.size(); i++){
            tmp=getNumPazienti(medici.get(i));
            if(tmp>max){
                max=tmp;
                indiceMax=i;
            }
        }
        return indiceMax;
    }
    private int trovaPosizionePaziente(int unNumeroTessera) throws NullPointerException{
        for(int i=0; i<pazienti.size(); i++){
            if(pazienti.get(i).getTesseraSanitaria()==unNumeroTessera){
                return i;
            }
        }
        throw new NullPointerException("Paziente non trovato");
    }
}
