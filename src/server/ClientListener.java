package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener implements Runnable{
    public static ServerSocket server;

    public void run() {
        server = Server.getServerSock();
        Integer i = 1;
        while (true) {
            try {
                Socket socket = server.accept();
                Server.getClients().add(new Client(socket, i));
                ++i;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
