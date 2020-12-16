package com.fsk.client;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {

        //ClientList c1 = new ClientList("Mesaj1", "Client1", "localhost", 8000);

        //Client client1 = new Client(c1.getAddress(), c1.getPort());

        Client client = new Client();
        client.connectClientToServer("localhost", 8000);
    }
}
