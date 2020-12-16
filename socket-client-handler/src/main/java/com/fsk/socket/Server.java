package com.fsk.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final String[] names = {"Furkan", "Sahin", "Alperen", "Ahmet", "Irfan", "Kayra", "Fatma"};
    private static final String[] adjs = {"computer engineering", "software engineering", "lawyer",
            "high school", "soldier", "soccerer", "home wife"};


    private static final ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(7);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(1905);

        while (true) {

            System.out.println("[SERVER] Waiting for client connection.");

            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to Client.");

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
            pool.execute(clientThread);

        }


    }

    public static String getRandomName() {
        String name = names[(int) (Math.random() * names.length)];
        String adj = adjs[(int) ((Math.random()) * adjs.length)];
        return name + " " + adj;
        //return null;
    }
}


