/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroJugador;
import dominio_domino.Jugador;
import dominio_dominodto.JugadorDTO;
import sink.Sink;

/**
 *
 * @author diego
 */
public class PipeGuardarJugador implements Pipe<Jugador> {

    @Override
    public void ejecutar(Jugador a) {
        Sink s = Sink.getInstance();
        s.addJugador(a);
    }
}
