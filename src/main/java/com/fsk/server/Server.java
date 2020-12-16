package com.fsk.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server start..!");
            System.out.println("Wait for client message..!");

            socket = server.accept();
            System.out.println("Client accepted..!");


            input = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream())
            );

            String content = "";
            while (!content.equals("STOP")){
                try {
                    content = input.readUTF();
                    System.out.println(content);
                }catch (Exception e){
                    System.out.println("Connect Error for Server..! Error Message: " + e.getMessage());
                }
            }
        }catch (Exception e){
            System.out.println("Server connect error: " + e.getMessage());
        }
    }
}
