/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeCrearPartida;
import Pipes.PipeNumeroFicas;
import sink.Sink;

/**
 *
 * @author diego
 */
public class FiltroCrearPartida implements Filtro<Integer> {

    @Override
    public void ejecutar(Integer numeroFichas) {
        Pipe p = new PipeNumeroFicas();
        p.ejecutar(numeroFichas);
    }

}
