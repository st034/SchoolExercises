import java.io.IOException;
import java.net.*;

public class Server{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("Server started on port: "+serverSocket.getLocalPort());
            serverSocket.accept();
            System.out.println("Client connected");
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
