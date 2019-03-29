/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2018/12/17
 */

public class Concorrenza2{
    static int tmp=0;
    public static void main(String[] args) {
		int count=0;
		ThreadConcorrente t=new ThreadConcorrente();
		t.start();
		do{
			tmp=0;
			do{
				tmp++;
			}while(tmp<1000000);
	    	count++;
		}while(tmp==1000000);
    	System.out.println("1: "+count);
    }
}
class ThreadConcorrente extends Thread{
	int count=0;
	public void run(){
    	do{
    		Concorrenza2.tmp=0;
    		do{
				Concorrenza2.tmp++;
			}while(Concorrenza2.tmp<1000000);
    		count++;
    	}while(Concorrenza2.tmp==1000000);
    	System.out.println("2: "+count);
	}
}