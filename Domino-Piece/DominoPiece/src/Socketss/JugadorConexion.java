/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socketss;

import Vista.IRecibir;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author diego
 */
public class JugadorConexion extends Thread {

    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream clientOutput;
    private Object objecto;
    private IRecibir i;
//    private Jframe frame;
    public JugadorConexion(Socket socket) {
        this.clientSocket = socket;
//        this.frame = frame;

        try {
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IRecibir getI() {
        return i;
    }

    public void setI(IRecibir i) {
        this.i = i;
    }

    public synchronized void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                objecto = in.readObject();

                if (objecto instanceof PartidaDTO) {

                    PartidaDTO partida = (PartidaDTO) objecto;
//                    Partida p = new Partida(partida.getNumero());
//                    if (partida.getJugador().isEmpty()) {
//                        //aqui se regresa al frame Unirse
//                    } else {
//                        List<Jugador> jugadores = new ArrayList<>();
//                        for (JugadorDTO s : partida.getJugador()) {
//                            Jugador j = new Jugador(s.getNombre(), s.getAvatar());
//                            jugadores.add(j);
//                        }
//                        p.setJugadores(jugadores);
//                         //aqui se regresa al frame Partida
//                    }

                }

            }
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones
        }
    }

    private synchronized void mostrarCambios() {

    }
}
