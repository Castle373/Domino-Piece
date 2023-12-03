/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import Evento.Evento;
import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearPartida;
import PipesAndFilters.Filters.FiltroInicio;

/**
 *
 * @author diego
 */
 class PipeInicio<T extends Evento>  implements Pipe<T> {

    private Filtro filtro;
    @Override
    public void ejecutar(T claseInicial) {
        
        filtro.ejecutar(claseInicial);

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
