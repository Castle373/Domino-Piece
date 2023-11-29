/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.IniciarVotacionPF;
import Evento.TerminarVotacionPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeRespuestaVotacion;
import dominio_dominodto.Acciones;

/**
 *
 * @author diego
 */
public class FiltroIniciarVotacionTerminar <T extends Evento> implements Filtro<T> {

    @Override
    public void ejecutar(T objeto) {

        if (objeto instanceof TerminarVotacionPF) {

            ((TerminarVotacionPF) objeto).setData(Acciones.INICIAR_VOTACION_TERMINAR);
        }
        Pipe<T> pipaFin = new PipeRespuestaVotacion();
        pipaFin.ejecutar(objeto);
    }

}
