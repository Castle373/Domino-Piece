/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import Pump.Datos;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.NumeroFichasDTO;
import dominio_dominodto.PartidaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import sink.Sink;

/**
 *
 * @author diego
 */
public class JugadorThread extends Thread {

    private Socket clientSocket;
    private ObjectOutputStream out;
    private Server server;
    private Object objecto;
    private Datos pump;
    private Sink sink;
    
    public JugadorThread(Socket socket, ObjectOutputStream out, Server server) {
        this.clientSocket = socket;
        this.out = out;
        this.server = server;
        this.pump= new Datos();
        this.sink.getInstance();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                 objecto = in.readObject();
                if (objecto instanceof NumeroFichasDTO) {
                    Integer s = (Integer) objecto;
                    pump.CrearPartida(s);
                    
                    
                    PartidaDTO W = new PartidaDTO(sink.getPartida().getNumeroFichas());
                    server.sendToAll(W);
                    
                }
                if (objecto instanceof JugadorDTO) {
//                   List<JugadorDTO> jugadores= new ArrayList<>();
//                    for (Jugador) {
//                        
//                    }
//                    W.setJugador(PartidaD)
                }
                // Cuando se recibe un objeto, se envía a todos los clientes
//                server.sendToAll(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones
        }
    }
}
