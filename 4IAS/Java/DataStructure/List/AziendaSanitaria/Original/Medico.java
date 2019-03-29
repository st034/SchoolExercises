public class Medico{
	private String nominativo;
	public Medico(String nominativo){
		this.nominativo=nominativo;
	}
	public String getNominativo(){
		return nominativo;
	}
	public boolean equals(Medico m){
		return m.nominativo.equals(nominativo);
	}
	public String toString(){
		return nominativo;
	}
}
