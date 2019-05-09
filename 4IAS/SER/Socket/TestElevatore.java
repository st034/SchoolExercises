import java.net.Socket;
import java.util.Scanner;
import java.io.*;

class TestElevatore {
    public static void main(String[] args)
    {
        try
        {
            Socket s=new Socket("localhost",10000);
            Scanner tastiera=new Scanner(System.in);
            char[] cbuf=new char[32];
            int quanti_letti = 0;
            String cosa_riceve = "";
            String cosa_inviare = "";
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            PrintWriter output=new PrintWriter(new BufferedOutputStream(s.getOutputStream()), true);

            while(!cosa_inviare.equals("DIS")){
                quanti_letti=isr.read(cbuf,0,cbuf.length);
                cosa_riceve = new String(cbuf, 0, quanti_letti);
                while(quanti_letti == cbuf.length && isr.ready()){
                    quanti_letti=isr.read(cbuf,0,cbuf.length);
                    cosa_riceve+= new String(cbuf, 0, quanti_letti);
                }
                System.out.println("Ricevuto ["+cosa_riceve+"]");
                cosa_inviare=tastiera.nextLine();
                output.println(cosa_inviare);
            }
            s.close(); 
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
