package com.fsk.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        ServerConnection serverConn = new ServerConnection(socket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConn).start();

        while (true){
            System.out.println(">");
            String command = keyboard.readLine();

            if (command.equals("quit")) break;
            out.println(command);
        }

        socket.close();
        System.exit(0);
    }
}
