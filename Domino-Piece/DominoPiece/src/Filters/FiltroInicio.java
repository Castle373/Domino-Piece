/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeCrearJugador;
import Pipes.PipeCrearPartida;
import Pipes.PipeFin;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class FiltroInicio implements Filtro {

    @Override
    public void ejecutar(Object objecto) {

        if (objecto instanceof Integer) {
            Pipe pipa = new PipeCrearPartida();
            pipa.ejecutar(objecto);
        }
        if (objecto instanceof JugadorDTO) {
            Pipe pipa = new PipeCrearJugador();
            pipa.ejecutar(objecto);
        }

    }

}
