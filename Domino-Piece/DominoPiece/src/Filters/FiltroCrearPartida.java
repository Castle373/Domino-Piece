/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import Evento.CrearPartidaPF;
import Evento.Evento;
import Pipes.Pipe;
import Pipes.PipeCrearPartida;
import Pipes.PipeFin;
import dominio_domino.Partida;
import dominio_dominodto.PartidaDTO;

/**
 *
 * @author diego
 */
public class FiltroCrearPartida<T extends Evento> implements Filtro<T> {

    @Override
    public void ejecutar(T numeroFichas) {
        PartidaDTO p = new PartidaDTO();

        if (numeroFichas instanceof CrearPartidaPF) {

            p = new PartidaDTO(((CrearPartidaPF) numeroFichas).getNumfichas());
            ((CrearPartidaPF) numeroFichas).setData(p);
        }
        Pipe<T> pipaFin = new PipeFin();
        pipaFin.ejecutar(numeroFichas);

    }

}
