import java.io.*;
import java.net.*;
import java.util.Scanner;

/*QUESTO PROGRAMMA è DECISAMENTE MIGLIORABILE, MA PER ADESSO VA BENE COSI :)*/

public class Client{
    public static void main(String[] args){
        Socket socket=null;
        Scanner  in=null,  stdIn=null;;
        PrintWriter out=null;
        try {
            socket = new Socket("localhost", 3000);
            System.out.println("Client: started");
            System.out.println("Client Socket: "+ socket);

            in = new Scanner(socket.getInputStream());

            OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            
            stdIn = new Scanner(System.in);
            String result;
            String userInput;
            while(true){
                System.out.println("WRITE A WORD IN ENGLISH AND PRESS ENTER ('exit' to exit):\n");
                userInput = stdIn.nextLine();
                System.out.println();
                out.println(userInput);
                if(userInput.toLowerCase().equals("exit")) break;
                System.out.println("MEANING: \n'''''");
                while(in.hasNextLine()){
                    result = in.nextLine();
                    if(result.equals("---")) break;//the server sends this string "---" when the meaning ends
                    if(result.equals("null"))
                        System.out.println("Word not found.");
                    else
                        System.out.println(result);
                }
                System.out.println("'''''");
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