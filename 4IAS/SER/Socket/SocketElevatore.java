import java.io.*;
import java.net.*;
public class SocketElevatore{
    public static void main(String[] args){
        Socket socket=null;
        BufferedReader in=null, stdIn=null;
        PrintWriter out=null;
        try{
            socket = new Socket("localhost",10000);
            System.out.println("Client started: "+socket);
            
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            in = new BufferedReader(isr);
            String str="";
            int intc = isr.read();
            char c=(char)intc;
            while(true){
                str+=c;
                if(str.equals("Connessione accettata")){
                    System.out.println(str);
                    break;
                }
                intc = isr.read();
                c=(char)intc;
            }
            
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);
            
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            
            while(true){
                System.out.println("Insert a command");
                userInput = stdIn.readLine();
                out.println(userInput);
                if (userInput.equals("DIS")) break;
                if (userInput.equals("POS")||userInput.equals("ELE")||userInput.equals("INF")){
                    intc=isr.read();
                    c=(char)intc;
                    str="";
                    String strNum="";
                    while(true){
                        if(!Character.isDigit(c)){
                            str+=c;
                        }
                        System.out.println(str);
                        if(str.equals("Posizione=")||str.equals("Elevatore scari")||str.equals("Elevatore cari")){
                            System.out.println(str + ((char)isr.read()) + ((char)isr.read()));
                            break;
                        }
                        
                        intc = isr.read();
                        c=(char)intc;
                    }
                }
            }
            System.out.println("Closing session");
            socket.close();
            in.close();
            out.close();
            stdIn.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
