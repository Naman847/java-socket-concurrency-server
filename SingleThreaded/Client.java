package SingleThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public void run() throws Exception {
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

        socket.close();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
