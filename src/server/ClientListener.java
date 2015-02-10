package server;

import java.io.*;
import java.net.*;

public class ClientListener implements Runnable{
    public static ServerSocket server;

    public void run() {
        server = Server.serverSock;
        Integer i = 1;
        while (true) {
            try {
                Socket socket = server.accept();
                Server.clients.add(new Client(socket, i));
                ++i;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
