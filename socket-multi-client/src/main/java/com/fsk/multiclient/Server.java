package com.fsk.multiclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ServerSocket serverSocket = null;

        System.out.println("Server listening...");

        serverSocket = new ServerSocket(8000);

        while (true){
            socket = serverSocket.accept();
            System.out.println("Connection Estanlished");
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
