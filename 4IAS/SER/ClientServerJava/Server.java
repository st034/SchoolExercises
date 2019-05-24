import java.io.*;
import java.net.*;

public class Server extends Thread{
    public static final int PORT = 10000;
    public Server() throws IOException {
        this.start();
    }
    public void run(){
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started: "+serverSocket);
            while(true){
            	System.out.println("Server ready for new connection");
            	Socket clientSocket = null;
            	BufferedReader in = null;
            
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted: "+clientSocket);
                
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                in = new BufferedReader(isr);
                
                while(true){
                    String s = in.readLine();
                    if(s.equals("end"))
                        break;
                    else
                        System.out.print(s+"\n");
                }
                System.out.println("Server closing");
                close(in, clientSocket);
            }
        }catch(Exception e){
        	throw new RuntimeException("Accept failed");
        }
    }
    public void close(BufferedReader r, Socket s)throws IOException{
        r.close();
        s.close();
    }
}
class ServerMain{
	public static void main(String[] args){
		try{
			new Server();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}