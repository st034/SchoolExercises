import java.util.Scanner;

public class InfSStack extends SStack {
	private int delta;
	
    public InfSStack(int m, int perc) {
    	super(m);
    	delta=perc;
    }
    public void push(char el){
    	if(ind==max){
    		char[] c=new char[max+((max*delta)/100)];
			for(int i=0;i<max;i++){
				c[i]=st[i];
			}
			c[max]=el;
			st=c;
			max=max+((max*delta)/100);
			ind++;
    	}else{
    		st[ind]=el;
    		ind++;
    	}
    }
    public static void main(String[] args){
    	Scanner s=new Scanner(System.in);
    	System.out.println("inserisci una parola");
    	String word=s.nextLine();
    	InfSStack wordChar = new InfSStack(10,20);
    	for(int i=0;i<word.length();i++){
    		wordChar.push(word.charAt(i));
    	}
    	for(int i=0;i<word.length();i++){
    		System.out.print(wordChar.pop());
    	}
    }
}