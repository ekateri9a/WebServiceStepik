package org.example.main;

import java.io.*;
import java.net.Socket;

public class ServerClientThread extends Thread {
    Socket serverClient;

    ServerClientThread(Socket inSocket){
        serverClient = inSocket;
    }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(serverClient.getOutputStream())), true);
            String clientMessage ="";
            do {
                clientMessage = in.readLine();
                out.println(clientMessage);
            } while (!clientMessage.equals("Bye."));
            serverClient.close();
            in.close();
            out.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}