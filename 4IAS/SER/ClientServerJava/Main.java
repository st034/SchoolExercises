import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        try{
            new Server();
            Scanner scn = new Scanner(System.in);
            String in;
            while(true){    
                System.out.println("Avviare un client socket?");
                in = scn.nextLine();
                if(in.equals("n")){
                    break;
                }else if(in.equals("y")){
                    new Client();
                }else{
                    System.out.println("error");
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}