/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import Evento.Evento;
import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroIniciarVotacion;

/**
 *
 * @author IVAN
 */
public class PipeIniciarVotacion<T extends Evento> implements Pipe<T> {

    private Filtro filtro;

    @Override
    public void ejecutar(T s) {

        filtro.ejecutar(s);
    }

    @Override
    public Filtro getFiltro() {
        return filtro;
    }

    @Override
    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

}
