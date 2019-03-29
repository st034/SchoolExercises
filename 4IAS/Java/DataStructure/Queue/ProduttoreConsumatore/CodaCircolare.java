
public class CodaCircolare {
	int[] array;
	int tail;
	int head;
	int length;
	int buffer;
	
    public CodaCircolare(int length) {
    	array=new int[length];
    	tail=0;
    	head=0;
    	this.length=length;
    	buffer=length;
    }
 	public void enqueue(int val)throws Exception{
 		if(!isFull()){
 			array[head]=val;
 			head=(head+1)%length;
 			buffer--;
 		}else{
 			throw new Exception("Stack pieno");
 		}
 	}
 	public int dequeue()throws Exception{
	 	if(!isEmpty()){
	 		int tmp=array[tail];
	 		tail=(tail+1)%length;
	 		buffer++;
	 		return tmp;
	 	}else{
	 		throw new Exception("Stack vuoto");
	 	}
 	}
 	public boolean isEmpty(){
 		return buffer==length;
 	}
 	public boolean isFull(){
 		return buffer==0;
 	}
}
