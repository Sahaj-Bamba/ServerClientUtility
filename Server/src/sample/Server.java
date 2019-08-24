package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    int port;

    Server(){
        port = 5566;
    }

    public void run(String args[]) {

        Socket socket;
        boolean flag = true;

        do {
            try {
                serverSocket = new ServerSocket(port);
                flag = false;
            } catch (IOException e) {
                e.printStackTrace();
                flag = true;
                port++;
            }
        }while(flag);

        while (true) {
            try {
                socket = serverSocket.accept();
                Thread t = new Thread(new HandleClient(socket));
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

    }

}
