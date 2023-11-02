/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeCrearPartida;
import Pipes.PipeFin;
import dominio_domino.Partida;

/**
 *
 * @author diego
 */
public class FiltroCrearPartida implements Filtro {

    @Override
    public void ejecutar(Object numeroFichas) {
        Partida p = new Partida();
        if (numeroFichas instanceof Integer) {
            int fichasIniciales = (int) numeroFichas;
            p = new Partida(fichasIniciales);
        } 
        Pipe pipaFin = new PipeFin();
        pipaFin.ejecutar(p);
        
    }

}
