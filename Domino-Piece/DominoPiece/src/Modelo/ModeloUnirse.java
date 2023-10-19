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

/**
 *
 * @author diego
 */
public class ModeloUnirse {

    private Partida partida;
    private Tablero tablero;
    private Pozo pozo;
    
    public ModeloUnirse() {
    }

    public void guardarPartida(Partida partida) {
        this.partida = partida;
    }
    
    public Jugador crearJugador(String nombre, Image avatar) {
        Jugador jugador = new Jugador(nombre, avatar);
        partida.addJugador(jugador);
        return jugador;
    }

    public Partida recuperaPartida() {
        return partida;
    }
    

}
