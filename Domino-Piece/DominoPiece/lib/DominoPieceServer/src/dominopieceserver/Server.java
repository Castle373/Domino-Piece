/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dominopieceserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Server {
    private List<ObjectOutputStream> clientOutputStreams = new ArrayList<>();

    public void addClientOutputStream(ObjectOutputStream outputStream) {
        clientOutputStreams.add(outputStream);
    }

    public void sendToAll(Object obj) {
        for (ObjectOutputStream out : clientOutputStreams) {
            try {
                out.writeObject(obj);
                out.flush();
            } catch (IOException e) {
                // Manejar excepciones
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Servidor inicializado en el puerto 1234");

        Server server = new Server();

        while (true) {
            Socket s = ss.accept();
            System.out.println("Nueva conexión por parte de cliente: " + s);

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            server.addClientOutputStream(out);

            JugadorHilo client = new JugadorHilo(s, out, server);
            client.start();
        }
    }
}
