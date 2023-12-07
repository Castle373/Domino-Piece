/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.BuscarPartidaPF;
import Evento.CrearPartidaPF;
import Evento.Evento;
import Evento.JugadorPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;

import dominio_dominodto.Acciones;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.util.UUID;

/**
 *
 * @author diego
 */
public class FiltroBuscarPartida<T extends Evento> implements Filtro<T> {

    private Pipe pipe;

    @Override
    public void ejecutar(T buscar) {

        if (buscar instanceof BuscarPartidaPF) {
            buscar.setData(Acciones.BUSCAR_PARTIDA);
        }
//        Pipe<T> pipaFin = new PipeFin();
        pipe.ejecutar(buscar);

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
