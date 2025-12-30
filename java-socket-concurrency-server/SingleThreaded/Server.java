package SingleThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() {
        int port = 8010;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);

            while (true) {
                System.out.println("Server is listening on port " + port);

                Socket acceptedConnection = serverSocket.accept();
                System.out.println(
                        "Connection accepted from client " +
                                acceptedConnection.getRemoteSocketAddress()
                );

                PrintWriter toClient =
                        new PrintWriter(acceptedConnection.getOutputStream(), true);
                BufferedReader fromClient =
                        new BufferedReader(new InputStreamReader(
                                acceptedConnection.getInputStream()
                        ));

                String clientMsg = fromClient.readLine();
                System.out.println("Client says: " + clientMsg);

                toClient.println("hello from my server!");

                acceptedConnection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
