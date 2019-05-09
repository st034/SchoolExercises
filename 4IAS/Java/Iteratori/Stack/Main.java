public class Main{
	public static void main(String[] args){
		try{
			StackIterable s = new StackIterable();
			
			for(int i=0; i<20; i++){
				s.push(i);
			}
			
			for(Object x: s){
				System.out.println(x);
			}
		}catch(Exception e){}
	}
}