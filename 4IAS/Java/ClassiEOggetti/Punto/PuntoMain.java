public class PuntoMain {

    public static void main(String[] args){

    	Punto p1=new Punto(20, 15);
    	Punto p2=new Punto(14, 16);

    	System.out.println("La distanza tra i 2 punti è: "+Punto.distanza(p1,p2));

    	p2=Punto.traslaY(p2, 10);

    	if(Punto.equals(p1,p2)){
    		System.out.println("I punti sono uguali");
    	}else{
    		System.out.println("I punti sono diversi");
    	}

    	System.out.println("Punto 2: "+p2.toString());

    	p2=Punto.copy(p1);

    	System.out.println("Dopo metodo copy:");

    	System.out.println("Punto 2: "+p2.toString());

    	if(Punto.equals(p1,p2)){
    		System.out.println("I punti sono uguali");
    	}else{
    		System.out.println("I punti sono diversi");
    	}
    }
}