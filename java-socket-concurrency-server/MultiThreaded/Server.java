package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try{
                PrintWriter toClient=new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.close();
                clientSocket.close();
            }catch(IOException ie){
                System.out.println(ie.getMessage());
            }
        };
    } 

    public static void main() {
        Server server=new Server();
        int port=8010;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port "+port);
            while(true){
                Socket socket = serverSocket.accept();
                Thread thread=new Thread(()->server.getConsumer().accept(socket)); 
                thread.start();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
