import java.io.*;
import java.net.*;
import java.util.*;
public class Client extends Thread{
    public Client()throws IOException{
        this.start();
    }
    public void run(){
        Socket socket = null;
        PrintWriter out = null;
        
        try{
            socket = new Socket("localhost", Server.PORT);
            System.out.println("Client started"+socket);
            
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            
            Scanner stdIn = new Scanner(System.in);
            
            String input;
            while(true){
                input = stdIn.nextLine();
                out.println(input);
                if(input.equals("end")){
                    break;
                }
            }
            System.out.println("Client closing");
            close(socket, out);
        }catch(Exception e){
            throw new RuntimeException("Connection failed");
        }
    }
    public void close(Socket s, PrintWriter out) throws IOException{
        out.close();
        s.close();
    }
}