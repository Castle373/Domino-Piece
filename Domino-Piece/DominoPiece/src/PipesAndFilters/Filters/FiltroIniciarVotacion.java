/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.IniciarVotacionPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;
import PipesAndFilters.Pipes.PipeIniciarVotacionTerminar;
import PipesAndFilters.Pipes.PipeRespuestaVotacion;
import dominio_dominodto.Acciones;

/**
 *
 * @author IVAN
 */
public class FiltroIniciarVotacion<T extends Evento> implements Filtro<T> {
private Pipe pipe;
    @Override
    public void ejecutar(T objeto) {

        if (objeto instanceof IniciarVotacionPF) {

            ((IniciarVotacionPF) objeto).setData(Acciones.INICIAR_VOTACION);
        }
       
        pipe.ejecutar(objeto);
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
