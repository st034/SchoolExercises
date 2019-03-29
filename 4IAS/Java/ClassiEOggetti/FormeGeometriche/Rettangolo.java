/**
 * @(#)Text1.java
 *
 *
 * @author
 * @version 1.00 2018/11/3
 */


public class Rettangolo {
	protected double base, altezza;
	protected Punto c;
    public Rettangolo(double pBase, double pAltezza, Punto p) {
    	base=pBase;
    	altezza=pAltezza;
    	c=p.copy();
    }
    public double area(){
    	return base*altezza;
    }
    public double perimetro(){
    	return (base*2)+(altezza*2);
    }
  	public String toString(){
  		return "Base: "+base+" | Altezza: "+altezza+" | Area: "+area()+" | Perimetro: "+perimetro()+".";
  	}
  	public Rettangolo copy(){
  		return new Rettangolo(this.base,this.altezza,this.c);
  	}
}
class Quadrato extends Rettangolo{
	public Quadrato(double lato, Punto pu){
		super(lato, lato, pu);
	}
	public Quadrato copy(){
		return new Quadrato(super.base, super.c);
	}
	public double getLato(){
		return super.base;
	}
}
class Punto{
	private double x, y;
	public Punto(double pX, double pY){
		x=pX;
		y=pY;
	}
	public Punto copy(){
		return new Punto(this.x, this.y);
	}
}
class Cerchio{
	private double raggio;
	private Punto c;
	
	public Cerchio(double r, Punto p){
		raggio=r;
		c=p.copy();
	}
	public double circonferenza(){
		return (raggio*2)*Math.PI;
	}
	public double area(){
		return Math.PI*(raggio*raggio);
	}
	public double getRaggio(){
		return raggio;
	}
	public Cerchio copy(){
		return new Cerchio(raggio, c);
	}
}
class CIQ{
	private Quadrato q;
	private Cerchio c;
	private Punto p;
	
	public CIQ(Punto pu, double lato){
		q = new Quadrato(lato,pu);
		c = new Cerchio(lato/2,pu);
		p = pu.copy();
	}
	public CIQ(Quadrato qua, Punto pu){
		q = qua.copy();
		c = new Cerchio(qua.getLato(), pu);
		p = pu.copy();
	}
	public CIQ(double sup, Punto pu){
		double lato=Math.sqrt(sup/(4-Math.PI));
		q = new Quadrato(lato, pu);
		c = new Cerchio(lato/2, pu);
		p = pu.copy();
	}
	public double area(){
		return this.q.area()-this.c.area();
	}
	public double perimetro(){
		return this.q.perimetro()+this.c.circonferenza();
	}
	public double sici(){
		return this.area()/4;
	}
	public double getLato(){
		return q.getLato();
	}
	public static void main(String[] args){
		Punto p=new Punto(0,0);
		CIQ forma=new CIQ(25.5,p);
		System.out.println(forma.getLato());
	}
}