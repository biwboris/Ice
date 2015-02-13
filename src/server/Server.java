package server;

import client.RealObj;
import pocket.ToClient;
import pocket.ToClientType;
import pocket.ToServer;
import pocket.ToServerType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ServerSocket serverSock;
    private static ArrayList<ObjectInputStream> oiss;
    private static ArrayList<ObjectOutputStream> ooss;

    private static Thread socketInit() {
        try {
            serverSock = new ServerSocket(17606);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Thread clientListener = new Thread(new ClientListener());
        clientListener.start();

        System.out.println("Sock init");
        return clientListener;
    }

    public static void main(String[] args) {
        socketInit();


    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ServerSocket getServerSock() {
        return serverSock;
    }

    public static void send(ToClientType t, String s, int n) {
        try {
            ooss.get(n).writeObject(new ToClient(t, s));
            ooss.get(n).flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(ArrayList < RealObj > objs, int n) {
        try {
            ooss.get(n).writeObject(new ToClient(objs));
            ooss.get(n).flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ObjectInputStream> getOiss() {
        return oiss;
    }

    public static ArrayList<ObjectOutputStream> getOoss() {
        return ooss;
    }
}
