/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import dominio_domino.Jugador;
import dominio_domino.Partida;
import dominio_domino.Pozo;
import dominio_domino.Tablero;
import java.awt.Image;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class ModeloUnirse {

    private Partida partida;
    private Jugador jugador;
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
    
    public void crearJugador(String nombre, Image avatar) {
        jugador = new Jugador(nombre, avatar);
        
        partida.addJugador(jugador);

    }

    public Partida recuperaPartida() {
        return partida;
    }
    
    public Jugador obtenerJugador() {
        
        return jugador;
    }
    
}
