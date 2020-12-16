package com.fsk.client;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    @Getter
    @Setter
    private ArrayList<ClientList> clientLists;

    public Client(){
        clientLists = new ArrayList<>();
    }

    public void connectClientToServer(String address, int port) throws IOException {


        ClientList c1 = new ClientList("Mesaj1", "Client1", "localhost", 8000);
        ClientList c2 = new ClientList("FSK", "Client2", "localhost", 8000);

        clientLists.add(c1);
        clientLists.add(c2);

        //
        try {
        //    for (ClientList item:
        //         clientLists) {
        socket = new Socket(address, port);
        //    }

            displayInformationSocket();

            for (int item = 0; item <clientLists.size() ; item++) {
                clientLists.get(item).setStop(true);
                clientLists.get(item).setAddress(address);
                System.out.println("Client: "+clientLists.get(item).getName() + " connected to SERVER on " +  clientLists.get(item).getPort());
            }


            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){
            System.out.println("Error Messsage. Connection Exception Message.: " + e.getMessage());
        }

        for (int i = 0; i < clientLists.size() ; i++) {
            clientLists.get(i).setMessage("");
        }


        /*

        while (!content.equals("STOP")){
            try {
                content = input.readLine();
                output.writeUTF(content);
            }catch (Exception e){
                System.out.println("Error Message. Message Error.: " + e.getMessage());
            }
        }

        */

        for(int i = 0; i<clientLists.size(); i++){
            while (!clientLists.get(i).getMessage().equals("STOP")){
                try {
                    clientLists.get(i).setMessage(clientLists.get(i).getName()+" Client sent message: "+input.readLine());
                    output.writeUTF(clientLists.get(i).getMessage());
                }catch (Exception e){
                    System.out.println("Error Message. Message Error.: " + e.getMessage());
                }
            }
        }



        try {
            input.close();
            output.close();
            socket.close();
        }catch (Exception e){
            System.out.println("Connection Cloes Error. Close Error.: " + e.getMessage());
        }
    }

    private void displayInformationSocket() {

        System.out.println("************************************************************************************");
        System.out.println("*                                                                                  *");
        System.out.println("*                           SOCKET INFORMATIONS                                    *");
        System.out.println("*                                                                                  *");
        System.out.println("*        Socket Channel:.............................: " + socket.getChannel() + "                        *");
        System.out.println("*        Socket Local Port:..........................: " + socket.getLocalPort() + "                       *");
        System.out.println("*        Socket INet Adres...........................: " + socket.getInetAddress() + "         *");
        System.out.println("*        Socket Local Socket Adres ..................: " + socket.getLocalSocketAddress() + "            *");
        System.out.println("*        Socket Port.................................: " + socket.getPort() + "                        *");
        System.out.println("*                                                                                  *");
        System.out.println("************************************************************************************");
    }
}
