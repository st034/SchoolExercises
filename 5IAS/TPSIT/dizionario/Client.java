import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args){
        Socket socket=null;
        BufferedReader in=null, stdIn=null;
        PrintWriter out=null;
        try {
            socket = new Socket("localhost", Server.PORT);
            System.out.println("Client: started");
            System.out.println("Client Socket: "+ socket);
            InputStreamReader isr = new InputStreamReader( socket.getInputStream());
            in = new BufferedReader(isr);
            
            OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            System.out.println("Le uniche parole sono 'felice' e 'sale'. Scrivere exit per uscire.\n");
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while(true){
                userInput = stdIn.readLine();
                out.println(userInput);
                if(userInput.toLowerCase().equals("exit")) break;
                String[] arrayResult = in.readLine().split("-");
                for(String result: arrayResult){
                    System.out.println(result);
                }
                System.out.println();
            }
            System.out.println("Client: closing...");
            out.close();
            in.close();
            stdIn.close();
            socket.close();
        }catch (IOException e) {
            System.exit(1);
        }   
    }
}