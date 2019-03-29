/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/3/20
 */

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
	public void aggMedico(String unNomeMedico){
		medici.add(new Medico(unNomeMedico));
	}
	public void eliminaPaziente(int unNumeroTessera){
		pazienti.remove(trovaPosizionePaziente(unNumeroTessera));
	}
	public void aggPaziente(int unNumeroTessera, String unNomeMedico){
		pazienti.add(new Paziente(unNumeroTessera, trovaMedico(unNomeMedico)));
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
class Medico{
	private String nominativo;
	public Medico(String nominativo){
		this.nominativo=nominativo;
	}
	public String getNominativo(){
		return nominativo;
	}
	public boolean equals(Medico m){
		return m.nominativo==nominativo;
	}
	public String toString(){
		return nominativo;
	}
}
class Paziente{
	int tesseraSanitaria;
	Medico medicoCurante;
	public Paziente(int tesseraSanitaria, Medico medicoCurante){
		this.tesseraSanitaria=tesseraSanitaria;
		this.medicoCurante=medicoCurante;
	}
	public int getTesseraSanitaria(){
		return tesseraSanitaria;
	}
	public Medico getMedicoCurante(){
		return medicoCurante;
	}
	public void setMedicoCurante(Medico newMedico){
		medicoCurante=newMedico;
	}
	public String toString(){
		return tesseraSanitaria+", "+medicoCurante;
	}
}