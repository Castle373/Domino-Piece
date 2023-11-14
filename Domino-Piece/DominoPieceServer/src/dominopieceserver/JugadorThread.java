/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominopieceserver;

import Evento.CrearPartidaPF;
import Evento.IniciarVotacionPF;
import Evento.JugadorPF;
import Evento.RespuestaVotacionPF;
import Evento.VerificarAvatarPF;
import dominio_dominodto.Acciones;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import dominio_dominodto.RespuestaDTO;
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
    private Votacion vota;

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

    public void enviarJugador() {
        
        jugador=sink.getJugadorDTO(jugador.getId());

        server.sendToOne(jugador, out);
    }

    public void enviarTodos(Object o) {
        server.sendToAll(o);
    }

    public void enviarAUno(Object o) {
        server.sendToOne(o, out);
    }

    public synchronized void enviarRespuesta(boolean respuesta) {
        Votacion.getInstance().respuestaVotacion(respuesta);
        this.notifyAll();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {

                objecto = in.readObject();//
                //Acciones de Crear Partida
                if (objecto instanceof CrearPartidaPF) {
                    CrearPartidaPF pf = (CrearPartidaPF) objecto;
                    PartidaDTO p = (PartidaDTO) pf.getData();
                    sink.CrearPartida(p);
                }
                //Acciones de Crear Jugador
                if (objecto instanceof JugadorPF) {
                    JugadorPF pf = (JugadorPF) objecto;
                    JugadorDTO j = (JugadorDTO) pf.getData();
                    jugador = j;
                    sink.agregarJugador(j);
                    enviarJugador();
                    enviarPartidaActual();
                    
                    if (sink.getPartidaDTO().getJugadores().size() >= 4) {
                        sink.iniciarPartida();
                        server.enviarJugadores();
                        server.enviarPartida();
                        enviarTodos(Acciones.INICIAR_PARTIDA);

                    }
                }
                //Acciones de Validar avatar
                if (objecto instanceof VerificarAvatarPF) {
                    VerificarAvatarPF pf = (VerificarAvatarPF) objecto;
                    JugadorDTO jA = (JugadorDTO) pf.getData();
                    if (!sink.verificarPartida(jA.getAvatar())) {
                        enviarAUno(Acciones.AVATAR_SIESTA);
                    } else {
                        enviarAUno(Acciones.AVATAR_NOESTA);
                    }
                }

                //Acciones de RespuestaVotacion
                if (objecto instanceof RespuestaVotacionPF) {
                    RespuestaVotacionPF pf = (RespuestaVotacionPF) objecto;
                    RespuestaDTO r = (RespuestaDTO) pf.getData();
                    Votacion.getInstance().respuestaVotacion(r.isRespuestas());

                }
                //Acciones  de IniciarVotacion
                if (objecto instanceof IniciarVotacionPF) {
                    IniciarVotacionPF pf = (IniciarVotacionPF) objecto;
                    Acciones a = (Acciones) pf.getData();
                    if (a == Acciones.INICIAR_VOTACION) {
                        vota = new Votacion(sink.getPartidaDTO().getJugadores().size(), server);
                        Votacion.setInstance(vota);
                        Votacion.getInstance().start();
                        
                        enviarTodos(Acciones.INICIAR_VOTACION);

                    }
                }

//                 if (objecto instanceof Acciones) {
//                     
//                   vota.respuestaVotacion(true);
//                    
//                }
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
