/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Evento.CrearPartidaPF;
import Evento.JugadorPF;
import Pipes.Pipe;
import Pipes.PipeInicio;
import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;
import dominio_dominodto.JugadorDTO;
import java.awt.Image;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class ModeloUnirse {

    private Partida partida;
    private JugadorDTO jugador;
    private Tablero tablero;
    private Pozo pozo;
    private Socket socket;

    public ModeloUnirse() {
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void guardarPartida(Partida partida) {
        this.partida = partida;
    }

    public void crearJugador(String nombre, String avatar) {

        Pipe<JugadorPF> pipa = new PipeInicio();
        JugadorPF j = new JugadorPF(nombre, avatar);
        pipa.ejecutar(j);

    }

    public Partida recuperaPartida() {
        return partida;
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

}
