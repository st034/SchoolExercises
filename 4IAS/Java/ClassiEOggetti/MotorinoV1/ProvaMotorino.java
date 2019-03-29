public class ProvaMotorino {
    public static void main(String[] args) {
		Motorino m1=new Motorino("BMW", "giallo");

		m1.mostraCapacita();
		m1.accendi();
		m1.viaggia(30);
		m1.mostraCapacita();
		m1.rifornisci(4);
		m1.mostraCapacita();
		Motorino m2= new Motorino(m1);

		m2.mostraSpecifiche();


		System.out.println(m1.equals(m2));
    }
}