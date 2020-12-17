package com.fsk.multiclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ServerSocket serverSocket = null;
        DataInputStream inputStream1 = null;
        DataInputStream inputStream2 = null;
        PrintWriter printWriter = null;

        String serverMsg = "";


        serverSocket = new ServerSocket(8080);

        System.out.println();

        /*

        System.out.println("************************** SERVER INFORMATION **************************");
        System.out.println();
        System.out.println("Server Socket Channel Name.................: " + serverSocket.getChannel());
        System.out.println("Server Socket INet Address.................: " + serverSocket.getInetAddress());
        System.out.println("Server Socket Local Port...................: " + serverSocket.getLocalPort());
        System.out.println("Server Socket Local Socket Address.........: " + serverSocket.getLocalSocketAddress());
        System.out.println();

         */

        System.out.println(".......... Server listening ..........");

        System.out.println();




        while (true){
            socket = serverSocket.accept();
            System.out.println();
            System.out.println("Connection Estanlished");
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
