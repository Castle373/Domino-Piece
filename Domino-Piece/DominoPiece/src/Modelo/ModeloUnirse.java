/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import dominio_domino.Jugador;
import dominio_domino.Partida;
import java.awt.Image;

/**
 *
 * @author diego
 */
public class ModeloUnirse {
    
    private Jugador jugador;
    public ModeloUnirse(){
        
    }
    public Jugador crearJugador(String nombre, Image avatar){
        jugador = new Jugador(nombre, avatar);
        return jugador;
    }
    public Partida recuperaPartida(){
        Partida partida = new Partida();
        return partida;
    }
    
}
