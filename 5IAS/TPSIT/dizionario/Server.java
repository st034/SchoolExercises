import java.io.*;
import java.net.*;

public class Server{
    public static final int PORT = 3000;
    public static void main(String[] args){
        Socket clientSocket;
        BufferedReader in;
        PrintWriter out;
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: "+PORT);
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(isr);
            
            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            while(true){
                String str = in.readLine();
                System.out.println("Received: "+ str);
                if(str.toLowerCase().equals("exit")) break;
                String result = getWord(str);
                System.out.println("Sending: "+ result);
                out.println(result);
            }

            System.out.println("Server: closing...");
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Accept failed");
            System.exit(1);
        }
        
    }
    public static String getWord(String word){
        String[] words = new String[2];
        
        words[0] = "contrari: triste-significato: sei felice";
        words[1] = "contrari: scende-significato: qualcuno o qualcosa che va verso l'alto";
        
        if(word.toLowerCase().equals("felice")) return words[0];
        if(word.toLowerCase().equals("sale")) return words[1];

        return "Parola non trovata nel dizionario.";
    }
}
