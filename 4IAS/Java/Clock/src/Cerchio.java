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
    	if(c.centro.distanza(this.centro)<(c.r+this.r)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static void main(String[] args){
    	Cerchio c1=new Cerchio(10,20,18);
    	Cerchio c2=new Cerchio(20,20,18);
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