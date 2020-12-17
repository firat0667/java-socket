package com.fsk.multiclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    String line = null;
    DataInputStream inputStream1 = null;
    DataInputStream inputStream2 = null;
    PrintWriter printWriter = null;
    Socket socket = null;

    public ServerThread(Socket s) {
        this.socket = s;
    }


    @Override
    public void run() {
        try {
            inputStream1 = new DataInputStream(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
            line = inputStream1.readLine();

            if (line.equals("QUIT"))
                line = "QUIT";

            while (!line.equals("QUIT")){
                printWriter.println(line);
                printWriter.flush();
                System.out.println("Response of Client: " + line);
                line = inputStream1.readLine();
            }

            inputStream1.close();
            printWriter.close();
            socket.close();

            System.out.println("Connection destroyed.!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
