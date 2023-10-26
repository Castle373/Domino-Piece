/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import Filters.FiltroCrearPartida;
import Filters.FiltroJugador;
import sink.Sink;

/**
 *
 * @author diego
 */
public class PipeCrearPartida implements Pipe<Integer>{

    @Override
    public void ejecutar(Integer numeroFicha) {
        Filtro f = new FiltroCrearPartida();
        f.ejecutar(f);
    }
    
    
}
