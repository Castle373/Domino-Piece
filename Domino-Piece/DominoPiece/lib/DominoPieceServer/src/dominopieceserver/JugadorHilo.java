/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class JugadorHilo extends Thread {
    private Socket clientSocket;
    private ObjectOutputStream out;
    private Server server;

    public JugadorHilo(Socket socket, ObjectOutputStream out, Server server) {
        this.clientSocket = socket;
        this.out = out;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                Object obj = in.readObject();

                // Cuando se recibe un objeto, se envía a todos los clientes
                server.sendToAll(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones
        }
    }
}
