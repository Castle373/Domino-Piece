/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeFin;
import dominio_domino.Partida;
import dominio_dominodto.JugadorDTO;

/**
 *
 * @author diego
 */
public class FiltroCrearJugador implements Filtro {

    @Override
    public void ejecutar(Object jugador) {
        JugadorDTO j = new JugadorDTO();
        if (jugador instanceof JugadorDTO) {
            j = (JugadorDTO) jugador;
        } 
        Pipe pipaFin = new PipeFin();
        pipaFin.ejecutar(j);
        
    }

}