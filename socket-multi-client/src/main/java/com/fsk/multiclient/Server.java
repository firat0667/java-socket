package com.fsk.multiclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class Server {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ServerSocket serverSocket = null;
        DataInputStream inputStream1 = null;
        DataInputStream inputStream2 = null;
        PrintWriter printWriter = null;

        String serverMsg = "";


        
        serverSocket = new ServerSocket(8000);

        System.out.println();
        System.out.println(".......... Server listening ..........");
        System.out.println();

        while (true){
            socket = serverSocket.accept();
            System.out.println();
            System.out.println("Connection Established");
            System.out.println();
            System.out.println(socket.getInetAddress().getHostAddress() + "-----> Host Address");
            System.out.println(socket.getInetAddress().getCanonicalHostName() + "-----> Canoncial Host Name");
            System.out.println(socket.getChannel() + " -----> Socket Get Channel");
            System.out.println();

            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
