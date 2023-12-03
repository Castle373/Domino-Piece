/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.CrearPartidaPF;
import Evento.Evento;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeBuscarPartida;
import PipesAndFilters.Pipes.PipeCrearPartida;
import PipesAndFilters.Pipes.PipeFin;
import dominio_dominodto.PartidaDTO;

/**
 *
 * @author diego
 */
public class FiltroCrearPartida<T extends Evento> implements Filtro<T> {
private Pipe pipe;
    @Override
    public void ejecutar(T numeroFichas) {
        PartidaDTO p = new PartidaDTO();

        if (numeroFichas instanceof CrearPartidaPF) {

            p = new PartidaDTO(((CrearPartidaPF) numeroFichas).getNumfichas());
            ((CrearPartidaPF) numeroFichas).setData(p);
        }
        
        pipe.ejecutar(numeroFichas);

    }

    @Override
    public Pipe getPipe() {
        return pipe;
    }

    @Override
    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }
}
