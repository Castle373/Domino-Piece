/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearJugador;
import Filters.FiltroCrearPartida;

/**
 *
 * @author diego
 */
public class PipeCrearJugador<T> implements Pipe<T> {

    @Override
    public void ejecutar(T jugador) {
        Filtro f = new FiltroCrearJugador();
        f.ejecutar(jugador);
      
    }
}