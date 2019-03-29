/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2019/3/20
 */


public class Main {

    public static void main(String[] args) {
    	AziendaSanitaria humanitas=new AziendaSanitaria();
    	try{
    	    humanitas.aggMedico("Gianni Cavanacciuolo");
        	humanitas.aggMedico("Luigi Piermonte");
        	humanitas.aggMedico("Carlo Magone");
        	humanitas.aggPaziente(12312,"Carlo Magone");
        	humanitas.aggPaziente(12341,"Luigi Piermonte");
        	humanitas.aggPaziente(41314,"Carlo Magone");
        	humanitas.aggPaziente(51125,"Carlo Magone");
        	humanitas.aggPaziente(24563,"Luigi Piermonte");
        	humanitas.aggPaziente(98763,"Carlo Magone");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    	System.out.println(humanitas.listaMedico("Carlo Magone"));
    	System.out.println(humanitas.statMedico());
    	humanitas.eliminaPaziente(41314);
    	System.out.println(humanitas.listaMedico("Carlo Magone"));
    }
    
    
}