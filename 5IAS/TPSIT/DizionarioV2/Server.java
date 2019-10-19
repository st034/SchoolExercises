import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*QUESTO PROGRAMMA è DECISAMENTE MIGLIORABILE, MA PER ADESSO VA BENE COSI :)*/

public class Server{
    public static final int PORT = 3000;
    public static void main(String[] args){
        Socket clientSocket;
        Scanner in;
        PrintWriter out;
        try{
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("dictionary.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: "+PORT);
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            in = new Scanner(clientSocket.getInputStream());
            
            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            while(true){
                System.out.println("Waiting for input");
                String str = in.nextLine();
                System.out.println("Received: "+ str);
                if(str.toLowerCase().equals("exit")) break;
                String result = (String) jsonObject.get(str.toLowerCase());
                System.out.println("Sending: "+ result);
                out.println(result+"\n---");
                System.out.println("Sent done:");
            }
            System.out.println("Server: closing...");
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            reader.close();
        } catch (Exception e) {
            System.err.println("Accept failed");
            System.err.println(e);
            System.exit(1);
        }
        
    }
}
