public class Quarta{
	public static void main(String[] args) throws Exception{
		int a,b,x,y,z;
		long exTime, exTimeTmp;
		
		exTime=System.currentTimeMillis();
		IlMioPrimoThread paolo = new IlMioPrimoThread();
		paolo.start();
		a = 3;
		b = 2;
		Thread.sleep(1000);
		x = a-b;
		paolo.join();
		y = paolo.y;
		z = x*y;
		exTimeTmp=System.currentTimeMillis()-exTime;		
		System.out.println("Quarta, tempo di esecuzione: "+exTimeTmp);		
		
		z=0;
		paolo.stop();
		
		exTime=System.currentTimeMillis();
		paolo.run();
		a = 3;
		b = 2;
		Thread.sleep(1000);
		x = a-b;
		paolo.join();
		y = paolo.y;
		z = x*y;
		exTimeTmp=System.currentTimeMillis()-exTime;		
		System.out.println("Terza, tempo di esecuzione: "+exTimeTmp);
							
	} 
}
class IlMioPrimoThread extends Thread{
	int y;
	public void run(){
		int c = 5; 
		int d = 4;
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		y = c+d;
	}
}