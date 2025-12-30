package MultiThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    public Runnable getRunnable(){
        return ()->{
            try{
                int port = 8010;
                InetAddress ip = InetAddress.getLocalHost();

                Socket socket = new Socket(ip, port);

                PrintWriter toSocket =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader fromSocket =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));

                toSocket.println("Hello from the client");

                String response = fromSocket.readLine();
                System.out.println("Response from the socket is: " + response);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        };
    }
    public static void main(String[] args) {
        Client client=new Client();
        for(int i=0;i<100;i++){
            try{
                Thread thread =new Thread(client.getRunnable());
                thread.start();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
