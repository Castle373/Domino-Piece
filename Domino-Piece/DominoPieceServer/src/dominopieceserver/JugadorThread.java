/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class JugadorThread extends Thread {

    private Socket clientSocket;

    private ObjectOutputStream out;
    private Server server;
    private Object objecto;
    private Sink sink;
    private JugadorDTO jugador;

    public JugadorThread(Socket socket, ObjectOutputStream out, Server server) {
        this.clientSocket = socket;
        this.out = out;
        this.server = server;
        this.sink = Sink.getInstance();
    }

    public void enviarPartidaActual() {
        PartidaDTO partidaActual = sink.getPartidaDTO();
        server.sendToAll(partidaActual);
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {

                objecto = in.readObject();// ATASCO

                if (objecto instanceof PartidaDTO) {
                    PartidaDTO p = (PartidaDTO) objecto;
                    sink.CrearPartida(p);
                }
                if (objecto instanceof JugadorDTO) {
                    JugadorDTO j = (JugadorDTO) objecto;
                    jugador = j;
                    sink.agregarJugador(j);
                    enviarPartidaActual();
                }
                // Cuando se recibe un objeto, se envía a todos los clientes
//                server.sendToAll(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            if (jugador != null) {
                sink.eliminarJugador(jugador);
                server.desconectarClliente(out);
                enviarPartidaActual();
                
            }
           
        }
    }
}
