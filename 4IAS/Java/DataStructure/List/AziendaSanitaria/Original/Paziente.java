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