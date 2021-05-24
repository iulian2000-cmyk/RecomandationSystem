package Server_Side;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static  void main(String[] args) throws Exception
    {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            System.out.println("Waiting clients...");
            while (true) {

                Socket client = server.accept();
                System.out.println("New client connected from IP: " + client.getInetAddress() .getHostAddress());
                ClientHandler clientSock  = new ClientHandler(client);
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}