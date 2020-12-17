package com.fsk.multiclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) throws IOException {
        String clientName = "Client 2";
        Socket socket = null;
        String line = null;
        DataInputStream inputStream1 = null;
        DataInputStream inputStream2 = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket("localhost", 8000);
            inputStream1 = new DataInputStream(System.in);
            inputStream2 = new DataInputStream(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
        }catch (IOException ioException){
            ioException.printStackTrace();
        }


        System.out.println("Enter Data to Echo Server ( **** Enter QUIT to END ****)");

        String response = null;

        try {
            line = inputStream1.readLine();
            while (!line.equals("QUIT")) {
                printWriter.println(line);
                printWriter.flush();
                response = inputStream2.readLine();
                System.out.println("Server response: " + response);
                line = inputStream1.readLine();
            }

            inputStream1.close();
            printWriter.close();
            inputStream2.close();

            System.out.println("Connection destroy..!");

        }catch (Exception e){
            e.getMessage();
        }


    }
}
