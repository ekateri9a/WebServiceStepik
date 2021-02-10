package org.example.main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            //InetAddress ia = InetAddress.getByName("localhost");
            ServerSocket server = new ServerSocket(5050);//, 0, ia);
            Logger.getGlobal().info("Server started");

            int n = 0;
            while(n<10){
                n++;
                Socket serverClient=server.accept();  // сервер принимает запрос на подключение клиента

                ServerClientThread sct = new ServerClientThread(serverClient); // отправляем запрос в отдельный поток
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}