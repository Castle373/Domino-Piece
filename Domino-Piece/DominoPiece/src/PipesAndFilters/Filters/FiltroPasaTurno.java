/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Filters;

import Evento.Evento;
import Evento.PasarTurnoPF;
import PipesAndFilters.Pipes.Pipe;
import PipesAndFilters.Pipes.PipeFin;

import dominio_dominodto.Acciones;

/**
 *
 * @author diego
 */
public class FiltroPasaTurno<T extends Evento> implements Filtro<T> {
    private Pipe pipe;
    @Override
    public void ejecutar(T objeto) {
        if (objeto instanceof PasarTurnoPF) {
            objeto.setData(Acciones.PASAR_TURNO);
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
