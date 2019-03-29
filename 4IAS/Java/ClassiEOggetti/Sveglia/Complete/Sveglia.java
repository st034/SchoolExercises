
public class Sveglia extends Time {
	private int mode, oreSveglia, minutiSveglia;
	public Sveglia(int pOre, int pMinuti, int pMode){
		super(pOre, pMinuti);
	}
	public Sveglia(){
		super();
		mode=0;
	}
	public boolean suona(Time t){
		if((oreSveglia==ore)&&(minutiSveglia==minuti)){
			if(mode==0){
				for(int i=0; i<=50;i++){
					System.out.println("SVEGLIA!");
				}
			}
			else if(mode==1){
				(new WAVPlayer()).playSound("sveglia.wav");
			}
			return true;
		}
		else{
			return false;
		}
	}
	public void setSveglia(int pOre, int pMinuti, int pMode){
		oreSveglia=pOre;
		minutiSveglia=pMinuti;
		this.mode=pMode;
	}
}