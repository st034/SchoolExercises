/**
 * @(#)CD.java
 *
 *
 * @author
 * @version 1.00 2018/10/5
 */


public class CD {
	private String[] cd1={	"CD1/Beethoven - Moonlight Sonata (1st Movement).wav",
										"CD1/RISE (ft The Glitch Mob, Mako, and The Word Alive)   Worlds 2018   League of Legends.wav"};
	private int currentTruck=0;

	void play(){
		(new WAVPlayer()).playSound(cd1[currentTruck]);
	}
	void nextTruck(){
		(new WAVPlayer()).playSound(cd1[currentTruck+1]);

	}
}