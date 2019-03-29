public class Test{
	public static void main(String[] args){
		int[] c=new int[20];
		int[] a=new int[10];
		c[1]=3;
		a=c;
		System.out.println(a[1]);
	}
}