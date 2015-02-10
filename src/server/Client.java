package server;

import java.net.*;

public class Client {
    private Socket socket;
    private String name;
    private Integer id;

    public Client(Socket sock, Integer n) {
        this.socket = sock;
        this.name = "Crustacean " + n.toString();
        this.id = n - 1;
    }
}
