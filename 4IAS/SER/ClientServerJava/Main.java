import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        try{
            Scanner scn = new Scanner(System.in);
            String in;
            while(true){    
                System.out.println("Avviare un client socket?(y/n)");
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