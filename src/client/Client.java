package client;

import pocket.ToServer;
import pocket.ToServerType;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
    private static int serverPort = 6666;
    private static String address = "127.0.0.1";
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    private static Queue<RealObj> queue = new LinkedList<RealObj>();
    private static ArrayList<Thread> threads;

    public static void main(String[] args) {
        initSock();
        initInput();

            /*
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            while (true) {
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }*/
    }

    private static void initInput() {

    }

    private static void initSock() {
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            ois = new ObjectInputStream(bis);

            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            oos = new ObjectOutputStream(bos);

            //Thread serverListener = new ServerListener();
            //serverListener
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(ToServerType t, ArrayList<Integer> i, String s) {
        try {
            oos.writeObject(new ToServer(t, i, s));
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObjectInputStream getOis() {
        return ois;
    }

    public static ObjectOutputStream getOos() {
        return oos;
    }

    public static Queue<RealObj> getQueue() {
        return queue;
    }
}
