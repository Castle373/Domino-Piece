/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PipesAndFilters.Pipes;

import PipesAndFilters.Filters.Filtro;
import PipesAndFilters.Filters.FiltroCrearPartida;

/**
 *
 * @author diego
 */
public class PipeCrearPartida<T> implements Pipe<T> {

    private volatile static PipeCrearPartida instance;

    public static synchronized PipeCrearPartida getInstance() {

        if (instance == null) {

            instance = new PipeCrearPartida();

        }
        return instance;
    }

    private Filtro filtro;

    @Override
    public void ejecutar(T numeroFicha) {

        filtro.ejecutar(numeroFicha);
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
