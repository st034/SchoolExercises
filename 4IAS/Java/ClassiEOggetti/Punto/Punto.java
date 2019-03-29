import java.lang.Math;

public class Punto{

	private double x;
	private double y;

    public Punto(double pX, double pY){
    	x=pX;
    	y=pY;
    }
    public Punto(double pX){
    	x=pX;
    }
    public Punto(){
    	x=0;
    	y=0;
    }
    public static double distanza(Punto p1, Punto p2){
		return Math.sqrt(Math.pow((p1.x-p2.x), 2)+Math.pow((p1.y-p2.y),2));
    }
    public static Punto traslaX(Punto p, double pX){
    	return (new Punto(p.x+pX, p.y));
    }
    public static Punto traslaY(Punto p, double pY){
    	return (new Punto(p.x, p.y+pY));
    }
	public static Punto copy(Punto p1){
		return (new Punto (p1.x, p1.y));
	}
	public static boolean equals(Punto p1, Punto p2){
		return ((p1.x==p2.x)&&(p1.y==p2.y));
	}
	public String toString(){
		return "La x vale: "+x+"| La y vale: "+y;
	}
}