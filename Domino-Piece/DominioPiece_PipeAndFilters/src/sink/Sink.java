/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sink;

import dominio_domino.Jugador;
import dominio_domino.Partida;
import java.util.List;

/**
 *
 * @author diego
 */
public class Sink {

    private volatile static Sink instance;
    
    
    private Partida partida;
    

    public Sink() {
        partida = new Partida();
    }

    public static synchronized Sink getInstance() {
        if (instance == null) {
            instance = new Sink();
        }
        return instance;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Partida getPartida() {
        return this.partida;
    }
    public int getNumeroFichas() {
        return partida.getNumeroFichas();
    }

    public void setNumeroFichas(int numeroFichas) {
        partida.setNumeroFichas(numeroFichas);
    }

    public List<Jugador> getJugadores() {
        return partida.getJugadores();
    }

    public void setJugadores(List<Jugador> jugadores) {
        partida.setJugadores(jugadores);
    }

    public void addJugador(Jugador jugador) {
        partida.addJugador(jugador);
    }

}
