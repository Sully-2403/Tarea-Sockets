package Client;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Common.*;

public class ServerClient implements Runnable {
    ServerSocket server;
    Socket client;
    ObjectInputStream input;
    Dot dot;
    Dot dot2;
    

    public ServerClient(Dot dotOriginal){
        dot = dotOriginal;
        try {
            server = new ServerSocket(4446);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void run(){
        try {
            while(true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                System.out.println("Guardado en input");
                dot2 = (Dot)input.readObject();
                dot.target = dot2.target;
                System.out.println("Se recibio el objeto");
                input.close();
                client.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
