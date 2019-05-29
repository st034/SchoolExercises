import java.net.*;
import java.io.*;
import java.util.*;

public class AstaClient
{
    Socket socket=null;
    Scanner in=null;
    PrintWriter out=null;
    public AstaClient() throws IOException{
        setupSocket();
    }

    public void setupSocket() throws IOException{
        socket = new Socket("localhost", 5555);
        System.out.println("EchoClient: started");
        System.out.println("Client Socket: "+ socket);
        //-----------------il client è connesso -----------------------------
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void inviaRilancio(int rilancio){
        out.println(rilancio);
        System.out.println("EchoClient: invia rilancio");
        ricevi();
    }

    public void inviaComando(int command) throws IOException{
        System.out.println("EchoClient: invia " + command);
        out.println(command);
        ricevi();
        if(command == -3) esci(); 
    }

    public void esci() throws IOException{
        System.out.println("EchoClient: closing...");
        out.close();
        in.close();
        socket.close();
    }

    public void ricevi(){
        if(in.hasNext()){
            int ricevuto = in.nextInt();
            System.out.println("EchoClient: ricevuto..." + ricevuto);
        }
    }
}