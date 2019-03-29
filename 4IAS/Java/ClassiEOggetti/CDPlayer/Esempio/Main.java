import java.io.*;

public class Main {
	public static void main (String[] args){
		int conta=0;

		WavLoader W = new WavLoader();
		int[] arrayInt = W.getArray();
		long size = W.getSize();

//-----Scrivi il codice tra queste 2 righe di commento--------------------------------------------------------------------------------//
		//l'array va modificato dalla posizione 44 in modo da non modificare l'header del file .wav

//-----------------------------------------------------------------------------------------------------------------------------------//
	Plotter plotter = new Plotter(arrayInt);
	plotter.showWave();

	W.play(arrayInt);
}}

