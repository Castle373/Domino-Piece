/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Pipes.Pipe;
import Pipes.PipeCrearPartida;
import Pipes.PipeFin;
import dominio_domino.Partida;
import dominio_dominodto.PartidaDTO;

/**
 *
 * @author diego
 */
public class FiltroCrearPartida implements Filtro {

    @Override
    public void ejecutar(Object numeroFichas) {
        PartidaDTO p = new PartidaDTO();
        if (numeroFichas instanceof Integer) {
            int fichasIniciales = (int) numeroFichas;
            p = new PartidaDTO(fichasIniciales);
        } 
        Pipe pipaFin = new PipeFin();
        pipaFin.ejecutar(p);
        
    }

}
