package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public static ServerSocket serverSock;

    private static void socketInit() {
        try {
            serverSock = new ServerSocket(17606);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Thread clientListener = new Thread(new ClientListener());
        clientListener.start();

        System.out.println("Sock init");
    }

    public static void main(String[] args) {
        System.out.println("hi, mother fucker");

        socketInit();


    }
}
