/**
 * @(#)Cerchio.java
 *
 *
 * @author 
 * @version 1.00 2018/11/30
 */


public class Cerchio {
	private Punto centro;
	private double r;
    public Cerchio(double x, double y, double raggio) {
    	centro=new Punto(x,y);
    	r=raggio;
    }
    public boolean interseca(Cerchio c){
    	return c.centro.distanza(this.centro)<(c.r+this.r);
    }
    public static void main(String[] args){
    	Cerchio c1=new Cerchio(10,20,4);
    	Cerchio c2=new Cerchio(20,20,4);
    	System.out.println(c1.interseca(c2));
    }
    
}
class Punto{
	private double x;
	private double y;
	public Punto(double pX, double pY){
		x=pX;
		y=pY;
	}
	public double distanza(Punto p){
		return Math.sqrt(Math.pow(p.x-this.x,2)+Math.pow(p.y-this.y,2));
	}
}
class Cilindro{
	private Cerchio base;
	private double altezza;
	public Cilindro(double raggio, double x, double y, double altezza){
		base=new Cerchio(x,y,raggio);
		this.altezza=altezza;
	}
	
}