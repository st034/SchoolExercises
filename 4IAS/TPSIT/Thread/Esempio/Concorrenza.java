/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2018/12/17
 */


public class Concorrenza{
	static int num=0, count=0;
    public static void main(String[] args) {
    	ThreadConcorrente t=new ThreadConcorrente();
    	t.start();
    	do{
    		num--;
    		count++;
    	}while(num!=0);
    	System.out.println(count);
    }
}
class ThreadConcorrente extends Thread{
	public void run(){
		do{
			Concorrenza.num++;
			Concorrenza.count++;
		}while(Concorrenza.num!=0);
	}
}