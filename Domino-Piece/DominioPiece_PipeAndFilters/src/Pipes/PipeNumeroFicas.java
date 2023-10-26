/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pipes;

import Filters.Filtro;
import dominio_dominodto.JugadorDTO;
import sink.Sink;

/**
 *
 * @author diego
 */
public class PipeNumeroFicas implements Pipe<Integer> {

    @Override
    public void ejecutar(Integer f) {
        Sink s = Sink.getInstance();
        s.setNumeroFichas(f);
    }

}
